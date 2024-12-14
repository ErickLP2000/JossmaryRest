package com.proyecto2.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.proyecto2.demo.entidad.Cliente;
import com.proyecto2.demo.entidad.Distrito;
import com.proyecto2.demo.entidad.Documento;
import com.proyecto2.demo.entidad.Tipocliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    private final String URL = "http://localhost:8098";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/list")
    public String inicio(Model model) throws Exception{
        try {
            ResponseEntity<Cliente[]> clientesResponse = restTemplate.getForEntity(URL + "/clientes/listar", Cliente[].class);
            ResponseEntity<Documento[]> documentosResponse = restTemplate.getForEntity(URL + "/documento/listar", Documento[].class);
            ResponseEntity<Tipocliente[]> tiposClienteResponse = restTemplate.getForEntity(URL + "/tipocliente/listar", Tipocliente[].class);
            ResponseEntity<Distrito[]> distritosResponse = restTemplate.getForEntity(URL + "/distrito/listar", Distrito[].class);

            model.addAttribute("listaCliente", clientesResponse.getBody());
            model.addAttribute("listaDocumento", documentosResponse.getBody());
            model.addAttribute("listaTipocliente", tiposClienteResponse.getBody());
            model.addAttribute("listaDistrito", distritosResponse.getBody());
            model.addAttribute("cliente", new Cliente());
        } catch (Exception e) {
            e.printStackTrace(); 
            model.addAttribute("error", "Error al listar las categorías.");
        }
        return "clientes/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model, RedirectAttributes flash) throws Exception {
        if (result.hasErrors()) {
            try {
                ResponseEntity<Cliente[]> clientesResponse = restTemplate.getForEntity(URL + "/clientes/listar", Cliente[].class);
                ResponseEntity<Documento[]> documentosResponse = restTemplate.getForEntity(URL + "/documento/listar", Documento[].class);
                ResponseEntity<Tipocliente[]> tiposClienteResponse = restTemplate.getForEntity(URL + "/tipocliente/listar", Tipocliente[].class);
                ResponseEntity<Distrito[]> distritosResponse = restTemplate.getForEntity(URL + "/distrito/listar", Distrito[].class);

                model.addAttribute("listaCliente", clientesResponse.getBody());
                model.addAttribute("listaDocumento", documentosResponse.getBody());
                model.addAttribute("listaTipocliente", tiposClienteResponse.getBody());
                model.addAttribute("listaDistrito", distritosResponse.getBody());
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("error", "Error al listar los clientes.");
            }
            return "clientes/inicio";
        }

        Gson gson = new Gson();
        String jsonCliente = gson.toJson(cliente);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonCliente, headers);

        try {
            if (cliente.getId() == null) {
                restTemplate.postForObject(URL + "/clientes/registrar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Cliente registrado");
            } else {
                restTemplate.put(URL + "/clientes/actualizar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Cliente actualizado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al guardar el cliente.");
            return "redirect:/clientes/form";
        }
        return "redirect:/clientes/list";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash) throws Exception {
        try {
            restTemplate.delete(URL + "/clientes/eliminar/" + id);
            flash.addFlashAttribute("mensaje", "Cliente eliminado");
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al eliminar cliente.");
        }
        return "redirect:/clientes/list";
    }
}