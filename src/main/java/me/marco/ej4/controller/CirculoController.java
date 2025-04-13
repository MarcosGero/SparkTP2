package me.marco.ej4.controller;

import me.marco.ej4.model.Circulo;
import spark.ModelAndView;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;

public class CirculoController {
        public static Route
                CircleView = (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/ej4/circulo.vtl");

            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej4/layout.vtl"));
        };
        public static Route
                getArea = (request, response) -> {
            String radio = request.queryParams("radio");

            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/ej4/circulo.vtl");
            Circulo circulo = new Circulo(radio);
            circulo.calcularArea();
            model.put("circulo", circulo);
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej4/layout.vtl"));
        };
        public static Route
                getPerimetro = (request, response) -> {
            String radio = request.queryParams("radio");

            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/ej4/circulo.vtl");
            Circulo circulo = new Circulo(radio);
            circulo.calcularPerimetro();
            model.put("circulo", circulo);
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej4/layout.vtl"));
        };
}
