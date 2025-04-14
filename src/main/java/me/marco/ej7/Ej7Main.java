package me.marco.ej7;

import me.marco.ej7.controller.GridoController;

import static me.marco.ej7.controller.GridoController.mostrarCanjes;
import static me.marco.ej7.controller.GridoController.verificarPuntos;
import static spark.Spark.*;
public class Ej7Main {
    public static void main(String[] args) {

        get("/ej7/grido", mostrarCanjes);
        get("/ej7/grido/verificar", verificarPuntos);
    }
}
