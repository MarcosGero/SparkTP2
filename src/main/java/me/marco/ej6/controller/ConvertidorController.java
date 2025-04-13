package me.marco.ej6.controller;

import java.util.HashMap;

import me.marco.ej6.model.Convertidor;
import spark.ModelAndView;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

public class ConvertidorController {


    public static Route mostrarConvertidor = (req, res) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/ej6/convertidor.vtl");
        String tipo = req.queryParams("tipo");
        String valor = req.queryParams("valor");


        if(tipo != null) {
            model.put("tipo", tipo);
            Convertidor convertidor = new Convertidor(tipo,valor);
            model.put("convertidor", convertidor);
        }

        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/ej6/layout.vtl")
        );
    };

    public static Route calcularConversion = (req, res) -> {
        String tipo = req.queryParams("tipo");
        String valorStr = req.queryParams("valor");
        String unidadOrigen = req.queryParams("unidadOrigen");


        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/ej6/convertidor.vtl");
        Convertidor convertidor = new Convertidor(tipo,valorStr);
        convertidor.setUnidadOrigen(unidadOrigen);
        convertidor.convertir();
        model.put("tipo", tipo);
        model.put("convertidor", convertidor);
        model.put("unidadOrigen", unidadOrigen);


        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/ej6/layout.vtl")
        );
    };
}

