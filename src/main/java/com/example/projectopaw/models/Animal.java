package com.example.projectopaw.models;

import java.net.URI;

public class Animal {
    private String nombre;
    private String descripcion;
    private URI foto;
    private String direccion;
    private Integer edad;
    private String raza;

    public Animal(String nombre, String descripcion, URI foto, String direcicon, Integer edad, String raza) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
        this.direccion = direcicon;
        this.edad = edad;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public URI getFoto() {
        return foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getRaza() {
        return raza;
    }
}