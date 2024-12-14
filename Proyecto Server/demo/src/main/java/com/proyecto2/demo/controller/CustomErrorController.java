package com.proyecto2.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(Model model) {
        // Agrega detalles del error al modelo si es necesario
        model.addAttribute("errorMessage", "Lo sentimos, ocurrió un error inesperado.");
        return "error"; // Nombre de la plantilla de error
    }

}

