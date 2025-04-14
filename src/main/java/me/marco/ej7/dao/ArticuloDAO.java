package me.marco.ej7.dao;

import me.marco.ej7.model.Articulo;
import java.util.*;

public class ArticuloDAO {
    private static final List<Articulo> articulos = new ArrayList<>();

    static {
        // Datos de ejemplo
        articulos.add(new Articulo("Helado Tentacion", 2000, 6000,30));
        articulos.add(new Articulo("Bombon Escoces", 5500, 5000,50));
        articulos.add(new Articulo("Pizza Mozzarella%", 2500, 4500,30));
        articulos.add(new Articulo("1/4 kilo de helado", 1500, 4000,50));
        articulos.add(new Articulo("1/2 kilo de helado", 3000, 7000,50));
    }

    public static List<Articulo> listarTodos() {
        return new ArrayList<>(articulos);
    }

    public static List<Articulo> obtenerDisponibles(int puntosUsuario) {
        List<Articulo> disponibles = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo.getPuntosRequeridos() <= puntosUsuario) {
                disponibles.add(articulo);
            }
        }
        return disponibles;
    }
}