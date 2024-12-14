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
import com.proyecto2.demo.entidad.Catproducto;

@Controller
@RequestMapping("/catproducto")
public class CatproductoController {

    private final String URL = "http://localhost:8098/catproducto";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/list")
    public String index(Model model) {
        try {
            ResponseEntity<Catproducto[]> responseEntity = restTemplate.getForEntity(URL + "/listar", Catproducto[].class);
            model.addAttribute("listaCatproducto", responseEntity.getBody());
            model.addAttribute("catproducto", new Catproducto());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "catproducto/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid @ModelAttribute Catproducto catproducto, BindingResult result, Model model, RedirectAttributes flash) {
        if (result.hasErrors()) {
            try {
                ResponseEntity<Catproducto[]> responseEntity = restTemplate.getForEntity(URL + "/listar", Catproducto[].class);
                model.addAttribute("listaCatproducto", responseEntity.getBody());
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("error", "Error al listar las categorías de productos.");
            }
            return "catproducto/inicio";
        }

        Gson gson = new Gson();
        String jsonCatproducto = gson.toJson(catproducto);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonCatproducto, headers);

        try {
            if (catproducto.getId() == null) {
                restTemplate.postForObject(URL + "/registrar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Categoría registrada");
            } else {
                restTemplate.put(URL + "/actualizar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Categoría actualizada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al guardar la categoría de producto.");
            return "redirect:/catproducto/form";
        }

        return "redirect:/catproducto/list";
    }

    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash){
        try {
            restTemplate.delete(URL + "/eliminar/" + id);
            flash.addFlashAttribute("mensaje", "Categoría eliminada");
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al eliminar la categoría de insumo.");
        }
        return "redirect:/catproducto/list";
    }
    
}
