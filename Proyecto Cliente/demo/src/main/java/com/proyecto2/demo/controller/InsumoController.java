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
import com.proyecto2.demo.entidad.Categoriainsu;
import com.proyecto2.demo.entidad.Insumo;
import com.proyecto2.demo.entidad.Marcainsu;
import com.proyecto2.demo.entidad.Proveedores;

@Controller
@RequestMapping("/insumo")
public class InsumoController {

    private final String URL = "http://localhost:8098";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/list")
    public String inicio(Model model) throws Exception {
        try {
            ResponseEntity<Categoriainsu[]> categoriasResponse = restTemplate.getForEntity(URL + "/catinsumo/listar", Categoriainsu[].class);
            ResponseEntity<Proveedores[]> proveedoresResponse = restTemplate.getForEntity(URL + "/proveedores/listar", Proveedores[].class);
            ResponseEntity<Marcainsu[]> marcasResponse = restTemplate.getForEntity(URL + "/marca/listar", Marcainsu[].class);
            ResponseEntity<Insumo[]> insumosResponse = restTemplate.getForEntity(URL + "/insumo/listar", Insumo[].class);

            model.addAttribute("listaCategoriainsu", categoriasResponse.getBody());
            model.addAttribute("listaProveedores", proveedoresResponse.getBody());
            model.addAttribute("listaMarcainsu", marcasResponse.getBody());
            model.addAttribute("listaInsumo", insumosResponse.getBody());
            model.addAttribute("insumo", new Insumo());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al realizar las solicitudes al servidor.");
        }
        return "insumo/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid @ModelAttribute Insumo insumo, BindingResult result, Model model, RedirectAttributes flash) throws Exception {
        if (result.hasErrors()) {
            try {
                ResponseEntity<Categoriainsu[]> categoriasResponse = restTemplate.getForEntity(URL + "/catinsumo/listar", Categoriainsu[].class);
                ResponseEntity<Proveedores[]> proveedoresResponse = restTemplate.getForEntity(URL + "/proveedores/listar", Proveedores[].class);
                ResponseEntity<Marcainsu[]> marcasResponse = restTemplate.getForEntity(URL + "/marca/listar", Marcainsu[].class);
                ResponseEntity<Insumo[]> insumosResponse = restTemplate.getForEntity(URL + "/insumo/listar", Insumo[].class);

                model.addAttribute("listaCategoriainsu", categoriasResponse.getBody());
                model.addAttribute("listaProveedores", proveedoresResponse.getBody());
                model.addAttribute("listaMarcainsu", marcasResponse.getBody());
                model.addAttribute("listaInsumo", insumosResponse.getBody());
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("error", "Error al listar los productos.");
            }
            return "insumo/inicio";
        }

        Gson gson = new Gson();
        String jsonInsumo = gson.toJson(insumo);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonInsumo, headers);

        try {
            if (insumo.getId() == null) {
                restTemplate.postForObject(URL + "/insumo/registrar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Insumo registrado");
            } else {
                restTemplate.put(URL + "/insumo/actualizar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Insumo actualizado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al guardar el Insumo.");
            return "redirect:/insumo/form";
        }
        return "redirect:/insumo/list";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash) throws Exception {
        restTemplate.delete(URL + "/insumo/eliminar/" + id);
        flash.addFlashAttribute("mensaje", "Insumo eliminado");
        return "redirect:/insumo/list";
    }
    
}