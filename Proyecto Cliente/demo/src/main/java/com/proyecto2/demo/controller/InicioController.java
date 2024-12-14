package com.proyecto2.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
    
    @RequestMapping("/pagina")
    public String inicio(){
        return "layout/index";
    }

    @RequestMapping("/admi")
    public String admin(){
        return "layout/admi";
    }

    @RequestMapping("/nosotros")
    public String nosotros(){
        return "layout/nosotros";
    }

    @RequestMapping("/mapa-sitio")
    public String mapasitio(){
        return "layout/mapasitio";
    }

    @RequestMapping("/nuestros-productos")
    public String productosInicio(){
        return "layout/productos";
    }

    @RequestMapping("/nuestros-servicios")
    public String serviciosInicio(){
        return "layout/servicios";
    }
  
}
