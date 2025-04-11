package me.marco.ej2.controller;

import me.marco.ej2.model.IMC;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

public class IMCController {
    public static Route
            getIMC = (Request req, Response res) -> {
                String peso = req.queryParams("peso");
                String altura = req.queryParams("altura");

                IMC response = new IMC(peso, altura);

                HashMap model = new HashMap();
                model.put("template", "templates/imc.vtl");
                model.put("imc", response);

                return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
            };
}
