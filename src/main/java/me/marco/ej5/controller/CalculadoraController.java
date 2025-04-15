package me.marco.ej5.controller;

import me.marco.ej5.model.Calculadora;
import spark.ModelAndView;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

public class CalculadoraController {
    public static
                Route Home = ( req, res) -> {
                    HashMap model = new HashMap();
                    model.put("template", "templates/ej5/calculadora.vtl");
                    Calculadora calculadora = new Calculadora(null,null);
                    model.put("calculadora", calculadora);

                    return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej5/layout.vtl"));
                };
    public static Route
                Sumar = ( req, res) -> {
                    String num1 = req.queryParams("num1");
                    String num2 = req.queryParams("num2");

                    HashMap model = new HashMap();
                    model.put("template", "templates/ej5/calculadora.vtl");
                    Calculadora calculadora = new Calculadora(num1,num2);
                    calculadora.sumar();
                    model.put("calculadora", calculadora);

                    return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej5/layout.vtl"));
                };
    public static Route
                Restar = ( req, res) -> {
                    String num1 = req.queryParams("num1");
                    String num2 = req.queryParams("num2");

                    HashMap model = new HashMap();
                    model.put("template", "templates/ej5/calculadora.vtl");
                    Calculadora calculadora = new Calculadora(num1,num2);
                    calculadora.restar();
                    model.put("calculadora", calculadora);

                    return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej5/layout.vtl"));
                };
    public static Route
                Multiplicar = ( req, res) -> {
                    String num1 = req.queryParams("num1");
                    String num2 = req.queryParams("num2");

                    HashMap model = new HashMap();
                    model.put("template", "templates/ej5/calculadora.vtl");
                    Calculadora calculadora = new Calculadora(num1,num2);
                    calculadora.multiplicar();
                    model.put("calculadora", calculadora);

                    return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej5/layout.vtl"));
                };
    public static Route
                Dividir = ( req, res) -> {
                    String num1 = req.queryParams("num1");
                    String num2 = req.queryParams("num2");

                    HashMap model = new HashMap();
                    model.put("template", "templates/ej5/calculadora.vtl");
                    Calculadora calculadora = new Calculadora(num1,num2);
                    calculadora.dividir();
                    model.put("calculadora", calculadora);

                    return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej5/layout.vtl"));
                };

}
