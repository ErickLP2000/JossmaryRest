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
import com.proyecto2.demo.entidad.Proveedores;

@Controller
@RequestMapping("/proveedores")
public class ProveedoresController {

    private final String URL = "http://localhost:8098/proveedores";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/list")
    public String inicio(Model model) throws Exception {
        try {
            ResponseEntity<Proveedores[]> proveedoresResponse = restTemplate.getForEntity(URL + "/listar", Proveedores[].class);
            model.addAttribute("listaProveedores", proveedoresResponse.getBody());
            model.addAttribute("proveedores", new Proveedores());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "proveedores/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid @ModelAttribute Proveedores proveedores, BindingResult result, Model model, RedirectAttributes flash) throws Exception {
        if (result.hasErrors()) {
            try {
                ResponseEntity<Proveedores[]> proveedoresResponse = restTemplate.getForEntity(URL + "/listar", Proveedores[].class);
                model.addAttribute("listaProveedores", proveedoresResponse.getBody());
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("error", "Error al listar los proveedores.");
            }
            return "proveedores/inicio";
        }

        Gson gson = new Gson();
        String jsonProveedores = gson.toJson(proveedores);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonProveedores, headers);

        try {
            if (proveedores.getId() == null) {
                restTemplate.postForObject(URL + "/registrar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Proveedor registrado");
            } else {
                restTemplate.put(URL + "/actualizar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Proveedor actualizado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al guardar el proveedor.");
            return "redirect:/proveedores/form";
        }
        return "redirect:/proveedores/list";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash) throws Exception {
        try {
            restTemplate.delete(URL + "/eliminar/" + id);
            flash.addFlashAttribute("mensaje", "Proveedor eliminado");
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al eliminar el proveedor.");
        }
        return "redirect:/proveedores/list";
    }
    
}