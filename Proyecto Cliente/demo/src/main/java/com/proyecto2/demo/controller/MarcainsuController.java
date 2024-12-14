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
import com.proyecto2.demo.entidad.Marcainsu;

@Controller
@RequestMapping("/marca")
public class MarcainsuController {
    
    private final String URL = "http://localhost:8098/marca";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/list")
    public String inicio(Model model) throws Exception {
        ResponseEntity<Marcainsu[]> marcasResponse = restTemplate.getForEntity(URL + "/listar", Marcainsu[].class);
        model.addAttribute("listaMarcainsu", marcasResponse.getBody());
        model.addAttribute("marcainsu", new Marcainsu());
        return "marca/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid @ModelAttribute Marcainsu marcainsu, BindingResult result, Model model, RedirectAttributes flash) throws Exception {
        if (result.hasErrors()) {
            try {
                ResponseEntity<Marcainsu[]> marcasResponse = restTemplate.getForEntity(URL + "/listar", Marcainsu[].class);
                model.addAttribute("listaMarcainsu", marcasResponse.getBody());
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("error", "Error al listar los servicios específicos.");
            }
            return "marca/inicio";
        }

        Gson gson = new Gson();
        String jsonMarcainsu = gson.toJson(marcainsu);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonMarcainsu, headers);

        try {
            if (marcainsu.getId() == null) {
                restTemplate.postForObject(URL + "/registrar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Marca registrada");
            } else {
                restTemplate.put(URL + "/actualizar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Marca actualizada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al guardar la marca del insumo.");
            return "redirect:/marca/form";
        }
        

        return "redirect:/marca/list";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash) throws Exception {
        restTemplate.delete(URL + "/eliminar/" + id);
        flash.addFlashAttribute("mensaje", "Marca eliminada");
        return "redirect:/marca/list";
    }
}