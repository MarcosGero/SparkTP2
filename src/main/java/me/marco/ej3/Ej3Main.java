package me.marco.ej3;

import me.marco.ej3.controller.PersonaController;

import static spark.Spark.get;  

public class Ej3Main {
    public static void main(String[] args) {
            get("/ej3/persona", PersonaController.getPersona);
            get("/ej3/personas", PersonaController.listarPersonas);
            get("/ej3/hijos", PersonaController.getHijos);
            get("/ej3/hermanos", PersonaController.getHermanos);
            get("/ej3/nietos", PersonaController.getNietos);
            get("/ej3/padres", PersonaController.getPadres);
            get("/ej3/tios", PersonaController.getTios);
            get("/ej3/sobrinos", PersonaController.getSobrinos);


    }
}
