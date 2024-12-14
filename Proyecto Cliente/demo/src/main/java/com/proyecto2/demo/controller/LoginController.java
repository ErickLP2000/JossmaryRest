package com.proyecto2.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto2.demo.entidad.AuthRequest;
import com.proyecto2.demo.entidad.AuthResponse;

@Controller
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;

    private final String AUTH_URL = "http://localhost:8098/auth/login";

    @RequestMapping("/") public String log(@RequestParam(value = "error", required = false) String error, Model model) { 
        System.out.println("Accediendo a la página de inicio de sesión"); 
        if (error != null) { 
            System.out.println("Error detectado: " + error); model.addAttribute("error", "Usuario/contraseña incorrectas"); 
        } return "index";
    }

    @PostMapping("/login")
    public String performLogin(@RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        AuthRequest authRequest = new AuthRequest(username, password);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AuthRequest> entity = new HttpEntity<>(authRequest, headers);

    try {
        System.out.println("Enviando solicitud de autenticación a: " + AUTH_URL);
        ResponseEntity<AuthResponse> response = restTemplate.postForEntity(AUTH_URL, entity, AuthResponse.class);

        System.out.println("Respuesta del servidor: " + response.getStatusCode());

        if (response.getStatusCode() == HttpStatus.OK) {
            AuthResponse authResponse = response.getBody();
            redirectAttributes.addFlashAttribute("token", authResponse.getToken());
            return "redirect:/admi";
        } else {
            System.out.println("Autenticación fallida: " + response.getStatusCode());
            redirectAttributes.addFlashAttribute("error", "Usuario/contraseña incorrecta");
            return "redirect:/?error";
        }
    } catch (Exception e) {
        System.out.println("Excepción durante la autenticación: " + e.getMessage());
        redirectAttributes.addFlashAttribute("error", "Usuario/contraseña incorrecta");
        return "redirect:/?error";
    }
}

}



