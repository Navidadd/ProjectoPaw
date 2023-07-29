package com.example.projectopaw.services;

import com.example.projectopaw.models.Usuario;
import com.example.projectopaw.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AunthenticationService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenthication(String email, String password){
        Usuario user = userRepository.findByEmail(email);

        if(user!=null){
            return user.getPassword().equals(password);
        }
        return false;
    }
}
