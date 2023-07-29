package com.example.projectopaw.controllers;

import com.example.projectopaw.models.Usuario;
import com.example.projectopaw.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private final UserRepository userRepository;

    public FormController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("titulo", "Inicio de sesion");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    @Transactional
    public String procesar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model, SessionStatus status, HttpSession session){

        if(result.hasErrors()){

            return "form";
        }
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getApellido());
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getPassword());
        System.out.println(usuario.getId());
        System.out.println(usuario.getEdad());
        System.out.println(usuario.getPais());
        System.out.println(result.getAllErrors());

        userRepository.save(usuario);
        session.setAttribute("usuario", usuario);

         return "forward:/";
    }

    @ModelAttribute("paises")
    public List<String> listaPaises(){

        return Arrays.asList("España", "Colombia", "Mexico", "Argentina");
    }


}
