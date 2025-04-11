package me.marco.ej2;

import me.marco.ej2.controller.IMCController;

import static spark.Spark.get;

public class Ej2Main {
    public static void main(String[] args) {
        get("/ej2/imc", IMCController.getIMC);
    }
}
