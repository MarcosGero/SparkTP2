package me.marco;

import me.marco.ej1.controller.OrdenarController;

import static spark.Spark.get;
public class Main {
    public static void main(String[] args) {

        get("/ej1/ordenar", OrdenarController.ordenarNumeros);
    }
}