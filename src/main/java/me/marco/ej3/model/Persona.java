package me.marco.ej3.model;

import java.util.List;

public class Persona {
    private String nombre;
    private int edad;
    private List<Persona> hijos;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Persona> getHijos() {
        return hijos;
    }

    public void setHijos(List<Persona> hijos) {
        this.hijos = hijos;
    }
}
