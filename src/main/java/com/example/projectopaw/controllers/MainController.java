package com.example.projectopaw.controllers;

import com.example.projectopaw.models.Animal;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping("/")
    public String main(Model model, HttpSession session){

        model.addAttribute("titulo","Projecto Paw");
        model.addAttribute("pageTitle","Proyecto para ayudar perritos");
        model.addAttribute("pageDescription","Perritos en adopcion");

        if (session.getAttribute("usuario") != null) {
            model.addAttribute("usuario", session.getAttribute("usuario"));
        } else {
            System.out.println("[MAIN] El usuario no existe");
        }

        return "main";
    }

    @ModelAttribute("animales")
    public List<Animal> poblarPerros() throws URISyntaxException {
        List<Animal> animales = new ArrayList<>();
        animales.add(new Animal("perro1", "perro muy feliz", new URI("/images/perrito1.jpg"), "direccion 1", 2, "supercan 1"));
        animales.add(new Animal("perro2", "perro muy triste", new URI("/images/perrito2.jpg"), "direccion 2", 3, "supercan 2"));
        animales.add(new Animal("perro3", "perro muy 3", new URI("/images/perrito3.jpg"), "direccion 3", 2, "supercan 3"));
        animales.add(new Animal("perro4", "perro muy 4", new URI("/images/perrito1.jpg"), "direccion 4", 2, "supercan 4"));
        animales.add(new Animal("perro15", "perro muy 5", new URI("/images/perrito2.jpg"), "direccion 5", 2, "supercan 5"));
        return animales;
    }
}
