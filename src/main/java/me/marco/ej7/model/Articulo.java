package me.marco.ej7.model;

public class Articulo {
    private String nombre;
    private int puntosRequeridos;
    private int descuento;
    private float precio;

    public Articulo(String nombre, int puntosRequeridos, float precio,int descuento) {
        this.nombre = nombre;
        this.puntosRequeridos = puntosRequeridos;
        this.precio = precio;
        this.descuento = descuento;
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getPuntosRequeridos() { return puntosRequeridos; }
    public float getPrecio() { return precio; }
    public int getDescuento() { return descuento; }
}