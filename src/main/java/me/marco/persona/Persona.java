/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.marco.persona;

import java.util.*;
//import  lombok.Data; Dejo de andar con la instalacion de IDE 25. Hay un bug en lombok

/**
 *
 * @author Daniel
 */
//@Data
//@Getter
public class Persona {
    String nombre;
    String apellido;
    List<Persona> hijos;
    
    public Persona(String nbre, String ape) {
        nombre = nbre; apellido = ape; hijos = new ArrayList<Persona>();
    }
    
    public void addHijo(Persona hijo) {
        hijos.add(hijo);
    }
   public String getNombre() {
        return nombre;
    }
   public String getApellido() {
        return apellido;
    }
     public List<Persona> getHijos() {
        return hijos;
    }
    
}

