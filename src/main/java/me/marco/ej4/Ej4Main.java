package me.marco.ej4;

import me.marco.ej4.controller.CirculoController;

import static spark.Spark.get;


public class Ej4Main {
    public static void main(String[] args) {
        get("/ej4/area", CirculoController.getArea);
        get("/ej4", CirculoController.CircleView);
        get("/ej4/perimetro", CirculoController.getPerimetro);
    }
}
