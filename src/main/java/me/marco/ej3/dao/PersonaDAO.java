package me.marco.ej3.dao;



import me.marco.ej3.model.Persona;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonaDAO {
    private static final Map<String, Persona> personas = new HashMap<>();

    //public static void addPerson(Persona person) {
    //    personas.put(person.getDni(), person);
    //}

    public static Persona getPerson(String dni) {
        return personas.get(dni);
    }

    public static List<Persona> listarPersonas() {
        return new ArrayList<>(personas.values());
    }
    static {

        Persona abuelo = new Persona( "Carlos", 70);
        Persona padre = new Persona("Juan", 45);
        Persona hijo1 = new Persona("Pedro", 20);
        Persona hijo2 = new Persona("María", 18);
        Persona nieto = new Persona("Luis", 5);

        padre.setHijos(Arrays.asList(hijo1, hijo2));
        hijo1.setHijos(Collections.singletonList(nieto));
        abuelo.setHijos(Collections.singletonList(padre));

        personas.put(abuelo.getNombre(), abuelo);
        personas.put(padre.getNombre(), padre);
        personas.put(hijo1.getNombre(), hijo1);
        personas.put(hijo2.getNombre(), hijo2);
        personas.put(nieto.getNombre(), nieto);
    }
    public static List<Persona> getHijos(String nombre) {
        Persona persona = personas.get(nombre);

        if (persona == null || persona.getHijos() == null) return Collections.emptyList();

        return persona.getHijos();
    }

    public static List<Persona> getPadres(String nombre) {
        Persona persona = personas.get(nombre);
        if (persona == null) return Collections.emptyList();

        return personas.values().stream()
                .filter(p -> p.getHijos() != null && p.getHijos().contains(persona))
                .collect(Collectors.toList());
    }

    public static List<Persona> getHermanos(String nombre) {
        List<Persona> padres = getPadres(nombre);
        return padres.stream()
                .flatMap(p -> p.getHijos().stream())
                .filter(h -> !h.getNombre().equals(nombre))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Persona> getNietos(String nombre) {
        return getHijos(nombre).stream()
                .flatMap(h -> h.getHijos() != null ? h.getHijos().stream() : Stream.empty())
                .collect(Collectors.toList());
    }

    public static List<Persona> getTios(String nombre) {
        List<Persona> padres = getPadres(nombre);
        return padres.stream()
                .flatMap(p -> getHermanos(p.getNombre()).stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Persona> getSobrinos(String nombre) {
        List<Persona> hermanos = getHermanos(nombre);
        return hermanos.stream()
                .flatMap(h -> h.getHijos() != null ? h.getHijos().stream() : Stream.empty())
                .collect(Collectors.toList());
    }
}
