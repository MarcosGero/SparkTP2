package me.marco.ej5;

import me.marco.ej5.controller.CalculadoraController;

import static spark.Spark.get;

public class Ej5Main {
    public static void main(String[] args) {
        get("/ej5",CalculadoraController.Home);
        get("/ej5/sumar", CalculadoraController.Sumar);
        get("/ej5/restar", CalculadoraController.Restar);
        get("/ej5/multiplicar", CalculadoraController.Multiplicar);
        get("/ej5/dividir", CalculadoraController.Dividir);

    }
}
