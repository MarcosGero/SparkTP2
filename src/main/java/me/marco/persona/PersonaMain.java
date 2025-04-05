/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.marco.persona;
import static spark.Spark.*; 

/**
 *
 * @author Daniel
 */
public class PersonaMain {
    public static void main(String[] args) { 
              
        // port(8080);
        get("/getPersonas", PersonaControlador.getPersonas); 
        get("/getHijos", PersonaControlador.getHijos); 
        get("/getNietos", PersonaControlador.getNietos); 
     
        
    }   
}
