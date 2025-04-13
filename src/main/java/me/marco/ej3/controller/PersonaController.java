package me.marco.ej3.controller;

import com.google.gson.Gson;
import me.marco.ej3.dao.PersonaDAO;
import me.marco.ej3.model.Persona;
import spark.ModelAndView;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

public class PersonaController {

        public static Route
                getPersona =(request, response) -> {
            String nombre = request.queryParams("nombre");
            Persona persona = PersonaDAO.getPerson(nombre);
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/ej3/personas.vtl");

            List<Persona> personas = PersonaDAO.listarPersonas();
            model.put("personas", personas);
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej3/layout.vtl"));
        };
        public static Route
                listarPersonas =(request, response) -> {

            List<Persona> personas = PersonaDAO.listarPersonas();
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/ej3/personas.vtl");
            model.put("personas", personas);
            model.put("nombre","");
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej3/layout.vtl"));
        };


    public static Route getHijos = (request, response) -> {
        String nombre = request.queryParams("nombre");
        List<Persona> hijos = PersonaDAO.getHijos(nombre);

        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/ej3/personas.vtl");
        model.put("personas", hijos);
        model.put("nombre", nombre);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej3/layout.vtl"));
    };

    public static Route getHermanos = (request, response) -> {
        String nombre = request.queryParams("nombre");
        List<Persona> hermanos = PersonaDAO.getHermanos(nombre);

        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/ej3/personas.vtl");
        model.put("personas", hermanos);
        model.put("nombre", nombre);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej3/layout.vtl"));
    };

    public static Route getNietos = (request, response) -> {
        String nombre = request.queryParams("nombre");
        List<Persona> nietos = PersonaDAO.getNietos(nombre);

        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/ej3/personas.vtl");
        model.put("personas", nietos);
        model.put("nombre", nombre);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej3/layout.vtl"));
    };

    public static Route getPadres = (request, response) -> {
        String nombre = request.queryParams("nombre");
        List<Persona> padres = PersonaDAO.getPadres(nombre);

        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/ej3/personas.vtl");
        model.put("personas", padres);
        model.put("nombre", nombre);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej3/layout.vtl"));
    };

    public static Route getTios = (request, response) -> {
        String nombre = request.queryParams("nombre");
        List<Persona> tios = PersonaDAO.getTios(nombre);

        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/ej3/personas.vtl");
        model.put("personas", tios);
        model.put("nombre", nombre);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej3/layout.vtl"));
    };

    public static Route getSobrinos = (request, response) -> {
        String nombre = request.queryParams("nombre");
        List<Persona> sobrinos = PersonaDAO.getSobrinos(nombre);

        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/ej3/personas.vtl");
        model.put("personas", sobrinos);
        model.put("nombre", nombre);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/ej3/layout.vtl"));
    };
}
