package me.marco.ej1;

import me.marco.ej1.controller.OrdenarController;

import static spark.Spark.get;
public class OrdenarMain {
    public static void main(String[] args) {

        get("/ej1/ordenar", OrdenarController.ordenarNumeros);
        get("/ej1/desordenar", OrdenarController.desordenarNumeros);
    }
}