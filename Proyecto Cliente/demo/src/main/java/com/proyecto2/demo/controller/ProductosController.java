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
import com.proyecto2.demo.entidad.Productos;

@Controller
@RequestMapping("/productos")
public class ProductosController {

    private final String URL = "http://localhost:8098";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/list")
    public String inicio(Model model) throws Exception {
        try {
            ResponseEntity<Catproducto[]> catproductosResponse = restTemplate.getForEntity(URL + "/catproducto/listar", Catproducto[].class);
            ResponseEntity<Productos[]> productosResponse = restTemplate.getForEntity(URL + "/productos/listar", Productos[].class);

            model.addAttribute("listaCatproducto", catproductosResponse.getBody());
            model.addAttribute("listaProductos", productosResponse.getBody());
            model.addAttribute("productos", new Productos());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al realizar las solicitudes al servidor.");
        }
        return "productos/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid @ModelAttribute Productos productos, BindingResult result, Model model, RedirectAttributes flash) throws Exception {
        if (result.hasErrors()) {
            try {
                ResponseEntity<Catproducto[]> catproductosResponse = restTemplate.getForEntity(URL + "/catproducto/listar", Catproducto[].class);
                ResponseEntity<Productos[]> productosResponse = restTemplate.getForEntity(URL + "/productos/listar", Productos[].class);

                model.addAttribute("listaCatproducto", catproductosResponse.getBody());
                model.addAttribute("listaProductos", productosResponse.getBody());
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("error", "Error al listar los productos.");
            }
            return "productos/inicio";
        }

        Gson gson = new Gson();
        String jsonProductos = gson.toJson(productos);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonProductos, headers);

        try {
            if (productos.getId() == null) {
                restTemplate.postForObject(URL + "/productos/registrar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Producto registrado");
            } else {
                restTemplate.put(URL + "/productos/actualizar", entity, String.class);
                flash.addFlashAttribute("mensaje", "Producto actualizado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.addFlashAttribute("error", "Error al guardar el producto.");
            return "redirect:/productos/form";
        }
        return "redirect:/productos/list";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash) throws Exception {
        restTemplate.delete(URL + "/productos/eliminar/" + id);
        flash.addFlashAttribute("mensaje", "Producto eliminado");
        return "redirect:/productos/list";
    }
    
}