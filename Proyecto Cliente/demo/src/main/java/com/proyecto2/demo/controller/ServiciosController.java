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
import com.proyecto2.demo.entidad.Espservicio;
import com.proyecto2.demo.entidad.Servicios;

@Controller
@RequestMapping("/servicios")
public class ServiciosController {

    private final String URL = "http://localhost:8098";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/list")
    public String inicio(Model model){
        try {
            ResponseEntity<Cliente[]> clientesResponse = restTemplate.getForEntity(URL + "/clientes/listar", Cliente[].class);
            ResponseEntity<Espservicio[]> espserviciosResponse = restTemplate.getForEntity(URL + "/espservicio/listar", Espservicio[].class);
            ResponseEntity<Servicios[]> serviciosResponse = restTemplate.getForEntity(URL + "/servicios/listar", Servicios[].class);

            if (clientesResponse.getBody() != null) {
                model.addAttribute("listaClientes", clientesResponse.getBody());
            } else {
                model.addAttribute("error", "Error al listar clientes.");
            }

            if (espserviciosResponse.getBody() != null) {
                model.addAttribute("listaEspservicio", espserviciosResponse.getBody());
            } else {
                model.addAttribute("error", "Error al listar especialidades de servicios.");
            }

            if (serviciosResponse.getBody() != null) {
                model.addAttribute("listaServicios", serviciosResponse.getBody());
            } else {
                model.addAttribute("error", "Error al listar servicios.");
            }

            model.addAttribute("servicios", new Servicios());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al realizar las solicitudes al servidor.");
        }
        return "servicios/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid @ModelAttribute Servicios servicios, BindingResult result, Model model, RedirectAttributes flash) {
        if (result.hasErrors()) {
            try {
                ResponseEntity<Cliente[]> clientesResponse = restTemplate.getForEntity(URL + "/cliente/listar", Cliente[].class);
                ResponseEntity<Espservicio[]> espserviciosResponse = restTemplate.getForEntity(URL + "/espservicio/listar", Espservicio[].class);
                ResponseEntity<Servicios[]> serviciosResponse = restTemplate.getForEntity(URL + "/servicios/listar", Servicios[].class);

                if (clientesResponse.getBody() != null) {
                    model.addAttribute("listaClientes", clientesResponse.getBody());
                }

                if (espserviciosResponse.getBody() != null) {
                    model.addAttribute("listaEspservicio", espserviciosResponse.getBody());
                }

                if (serviciosResponse.getBody() != null) {
                    model.addAttribute("listaServicios", serviciosResponse.getBody());
                }
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("error", "Error al listar los servicios.");
            }
            return "servicios/inicio";
        }

        Gson gson = new Gson();
        String jsonServicios = gson.toJson(servicios);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonServicios, headers);

        try {
            if (servicios.getId() == null) {
                restTemplate.postForObject(URL + "/servicios/registrar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Servicio registrado");
            } else {
                restTemplate.put(URL + "/servicios/actualizar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Servicio actualizado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al guardar el servicio.");
            return "redirect:/servicios/form";
        }

        return "redirect:/servicios/list";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash) {
        try {
            restTemplate.delete(URL + "/servicios/eliminar/" + id);
            flash.addFlashAttribute("mensaje", "Servicio eliminado");
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al eliminar el servicio.");
        }
        return "redirect:/servicios/list";
    }
}
