package com.example.projectopaw.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Entity
@SessionScope
@Component
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "el nombre no puede estar vacio")
    private String nombre;
    @NotEmpty(message = "el apellido no puede estar vacio")
    private String apellido;

    @NotBlank(message = "no puede tener espacios")
    private String password;

    @NotEmpty(message = "No puede estar vacio")
    @Email(message = "Tiene que ser un email valido")
    private String email;

    @NotNull(message = "Edad invalida")
    @Min(5)
    private Integer edad;

    @NotEmpty (message = "Tiene que seleccionar un pais")
    private String Pais;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }
}
