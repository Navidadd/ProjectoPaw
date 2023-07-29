package com.example.projectopaw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

/**
 * ProfileController
 */
@Controller
public class ProfileController {

  @RequestMapping("/perfil")
  public String profile(Model model, HttpSession session){
    model.addAttribute("usuario", session.getAttribute("usuario"));

    return "profile";
  }
  
}
