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
import com.proyecto2.demo.entidad.Espservicio;

@Controller
@RequestMapping("/espservicio")
public class EspservicioController {

    private final String URL = "http://localhost:8098/espservicio";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/list")
    public String index(Model model) {
        try {
            ResponseEntity<Espservicio[]> responseEntity = restTemplate.getForEntity(URL + "/listar", Espservicio[].class);
            model.addAttribute("listaEspservicio", responseEntity.getBody());
            model.addAttribute("espservicio", new Espservicio());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "espservicio/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid @ModelAttribute Espservicio espservicio, BindingResult result, Model model, RedirectAttributes flash) throws Exception {
        if (result.hasErrors()) {
            try {
                ResponseEntity<Espservicio[]> responseEntity = restTemplate.getForEntity(URL + "/listar", Espservicio[].class);
                model.addAttribute("listaEspservicio", responseEntity.getBody());
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("error", "Error al listar los servicios específicos.");
            }
            return "espservicio/inicio";
        }

        Gson gson = new Gson();
        String jsonEspservicio = gson.toJson(espservicio);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonEspservicio, headers);

        try {
            if (espservicio.getId() == null) {
                restTemplate.postForObject(URL + "/registrar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Servicio específico registrada");
            } else {
                restTemplate.put(URL + "/actualizar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Servicio específico actualizada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al guardar la servicio específico.");
            return "redirect:/catproducto/form";
        }
        return "redirect:/espservicio/list";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash) throws Exception {
        try {
            restTemplate.delete(URL + "/eliminar/" + id);
            flash.addFlashAttribute("mensaje", "Servicio específico eliminada");
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al eliminar la Servicio Especifico.");
        }
        return "redirect:/espservicio/list";
    }
    
}
