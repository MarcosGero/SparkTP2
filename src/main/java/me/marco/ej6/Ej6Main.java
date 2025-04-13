package me.marco.ej6;

import me.marco.ej6.controller.ConvertidorController;

import static spark.Spark.*;
public class Ej6Main {
    public static void main(String[] args) {

        get("/ej6", ConvertidorController.mostrarConvertidor);
        get("/ej6/calcular", ConvertidorController.calcularConversion);
    }
}
