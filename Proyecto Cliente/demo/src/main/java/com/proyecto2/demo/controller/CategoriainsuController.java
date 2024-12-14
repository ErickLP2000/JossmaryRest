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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.proyecto2.demo.entidad.Categoriainsu;

@Controller
@RequestMapping("/catinsumo")
public class CategoriainsuController {

    private final String URL = "http://localhost:8098/catinsumo";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/list")
    public String index(Model model) {
        try {
            ResponseEntity<Categoriainsu[]> responseEntity = restTemplate.getForEntity(URL + "/listar", Categoriainsu[].class);
            model.addAttribute("listaCategoriainsu", responseEntity.getBody());
            model.addAttribute("categoriainsu", new Categoriainsu());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al listar las categorías de insumos.");
        }
        return "catinsumo/inicio";
    }

    @PostMapping("/form")
    public String guardar(@Valid @ModelAttribute Categoriainsu categoriainsu, BindingResult result, Model model, RedirectAttributes flash) {
        if (result.hasErrors()) {
            try {
                ResponseEntity<Categoriainsu[]> responseEntity = restTemplate.getForEntity(URL + "/listar", Categoriainsu[].class);
                model.addAttribute("listaCategoriainsu", responseEntity.getBody());
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("error", "Error al listar las categorías de insumos.");
            }
            return "catinsumo/inicio";
        }

        Gson gson = new Gson();
        String jsonCategoriainsu = gson.toJson(categoriainsu);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonCategoriainsu, headers);

        try {
            if (categoriainsu.getId() == null) {
                restTemplate.postForObject(URL + "/registrar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Categoría registrada");
            } else {
                restTemplate.put(URL + "/actualizar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Categoría actualizada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al guardar la categoría de insumo.");
            return "redirect:/catinsumo/form";
        }

        return "redirect:/catinsumo/list";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash) {
        try {
            restTemplate.delete(URL + "/eliminar/" + id);
            flash.addFlashAttribute("mensaje", "Categoría eliminada");
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al eliminar la categoría de insumo.");
        }
        return "redirect:/catinsumo/list";
    }
}
