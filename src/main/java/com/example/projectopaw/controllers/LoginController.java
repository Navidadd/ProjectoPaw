package com.example.projectopaw.controllers;

import com.example.projectopaw.models.Usuario;
import com.example.projectopaw.repositories.UserRepository;
import com.example.projectopaw.services.AunthenticationService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario")
public class LoginController {

    @Autowired
    private AunthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginResult(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        
        if (authenticationService.authenthication(email, password)) {
            // Autenticación exitosa, redirigir a la página principal
            Usuario user = userRepository.findByEmail(email);
            session.setAttribute("usuario", user);
            return "redirect:/";
        } else {
            return "redirect:/login?error";
        }
    }
}
