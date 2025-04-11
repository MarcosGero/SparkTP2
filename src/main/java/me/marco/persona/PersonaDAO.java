/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.marco.persona;
import java.util.*;
/**
 *
 * @author Daniel
 */
public class PersonaDAO {
    private List<Persona> personas;
    
    public void init() {
       personas = new ArrayList<Persona>();
        Persona pJuan = new Persona("JUAN", "PEREZ");
        
        personas.add(pJuan);
        
        Persona pJuan1 = new Persona("JUAN1", "PEREZ");
        personas.add(pJuan1);
        pJuan.addHijo(pJuan1);
        
        Persona pJuana1 = new Persona("JUANA1", "PEREZ");
        personas.add(pJuana1);
        pJuan.addHijo(pJuana1);
        
        Persona pJuan11 = new Persona("JUAN11", "PEREZ");
        personas.add(pJuan11);
        pJuan1.addHijo(pJuan11);
        
        Persona pJuan12 = new Persona("JUAN12", "PEREZ");
        personas.add(pJuan12);
        pJuan1.addHijo(pJuan12);
        
        Persona pJuana11 = new Persona("JUANA11", "PEREZ");
        personas.add(pJuana11);
        pJuana1.addHijo(pJuana11);
    }
    
    public List<Persona> getPersonas() {
        init();
        return personas;
    }
    
    public List<Persona> getNietos(String nombre) {
        init();
        List<Persona> nietos;
        nietos = new ArrayList<>();
        if (nombre == null ) return nietos;
        Persona pEncontrada = personas.stream()                 // Convierte a stream
                .filter(p -> nombre.equals(p.getNombre()))        // buscamos la persona
                .findAny()                                      // Si 'findAny' entonces retorna la persona
                .orElse(null);                                  // sino null.
        if (pEncontrada != null) {
            pEncontrada.getHijos().forEach(persona ->{
                nietos.addAll(persona.getHijos());
            });
	}
        return nietos;
    }
    
    public List<Persona> getHijos(String nombre) {
        init();
        List<Persona> hijos;
        hijos = new ArrayList<Persona>();
        if (nombre == null ) return hijos;
        Persona pEncontrada = personas.stream()                 // Convierte a stream
                .filter(p -> nombre.equals(p.getNombre()))        // buscamos la persona
                .findAny()                                      // Si 'findAny' entonces retorna la persona
                .orElse(null);                                  // sino null.
        if (pEncontrada != null) {
            hijos = pEncontrada.getHijos();
	}
        return hijos;
    }
    
  
}
