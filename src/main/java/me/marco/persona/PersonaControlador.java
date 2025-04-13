/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.marco.persona;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.List;

import java.util.HashMap; 
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;



/**
 *
 * @author Daniel
 */
public class PersonaControlador {
    static PersonaDAO  pDAO = new PersonaDAO();
   
   
    public static Route 
        getPersonas = (Request req, Response res) -> {
              List<Persona> p = pDAO.getPersonas(); 
           
            HashMap model = new HashMap();
            model.put("personas", p);
            model.put("nombre", "");
            model.put("template", "templates/examples/personas.vtl");
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl")); };
     

    public static Route 
        getHijos = (Request req, Response res) -> {
 //           PersonaDAO pDAO = new PersonaDAO();
            String nbre = req.queryParams("nombre");

            List<Persona> hijos = pDAO.getHijos(nbre);
            
            HashMap model = new HashMap();
            model.put("hijos", hijos);
            model.put("nombre", nbre);
            model.put("template", "templates/examples/hijos.vtl");
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl")); };
           
    public static Route 
        getNietos = (Request req, Response res) -> {
 //           PersonaDAO pDAO = new PersonaDAO();
            String nbre = req.queryParams("nombre");

            List<Persona> nietos = pDAO.getNietos(nbre); 
            
            HashMap model = new HashMap();
            model.put("nietos", nietos);
            model.put("nombre", nbre);
            model.put("template", "templates/examples/nietos.vtl");
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl")); };


        
    

}


