package com.example.projectopaw.repositories;

import com.example.projectopaw.models.Usuario;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String username);
    Usuario save(Usuario usuario);
}
