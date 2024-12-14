package com.proyecto2.demo.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String log(@RequestParam(value = "error", required = false) String error, Model model) {
        // Verifica si el usuario ya está autenticado
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            // Redirige a /admi si el usuario ya está autenticado
            return "redirect:/admi";
        }

        if (error != null) {
            model.addAttribute("error", "usuario/contraseña incorrecta");
        }
        return "index"; // Nombre de la plantilla de login
    }
}


