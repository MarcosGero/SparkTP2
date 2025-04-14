package me.marco.ej7.controller;

import java.util.*;
import me.marco.ej7.dao.ArticuloDAO;
import spark.ModelAndView;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;


public class GridoController {


    public static Route mostrarCanjes = (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("template", "templates/ej7/grido.vtl");
        model.put("articulos", ArticuloDAO.listarTodos());
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/ej7/layout.vtl")
        );
    };

    public static Route verificarPuntos = (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("template", "templates/ej7/grido.vtl");

        try {
            int puntos = Integer.parseInt(req.queryParams("puntos"));
            model.put("puntosIngresados", puntos);
            model.put("articulosDisponibles", ArticuloDAO.obtenerDisponibles(puntos));
        } catch (NumberFormatException e) {
            model.put("error", "Ingrese un número válido de puntos");
        }

        model.put("articulos", ArticuloDAO.listarTodos());
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/ej7/layout.vtl")
        );
    };
}