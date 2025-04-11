package me.marco.ej1.controller;

import me.marco.ej1.model.Numbers;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

public class OrdenarController {
    public static Route
            ordenarNumeros = (Request request, Response res) -> {
                Numbers numbersModel = new Numbers();

                String[] numberParams = request.queryParamsValues("number");

                List<String> inputNumbers = new ArrayList<>();
                HashMap model = new HashMap();

                model.put("template", "templates/ordenar.vtl");

                if (numberParams != null) {
                    inputNumbers.addAll(Arrays.asList(numberParams));
                }
                while (inputNumbers.size() < 6) {
                    inputNumbers.add("");
                }
                numbersModel.setNumbers(inputNumbers);
                numbersModel.setRearrangedNumbers(inputNumbers);

                model.put("numbers", numbersModel);

                List<Integer> intList = new ArrayList<>();

                for (String numStr : numbersModel.getNumbers()) {
                    try {
                        intList.add(Integer.parseInt(numStr.trim()));
                    } catch (NumberFormatException ignored){

                    }
                }

                Collections.sort(intList);

                List<String> newNumbers = new ArrayList<>();
                for (Integer num : intList) {
                    newNumbers.add(num.toString());
                }
                numbersModel.setRearrangedNumbers(newNumbers);

                model.put("numbers", numbersModel);

                return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
        };
    public static Route
        desordenarNumeros = (Request request, Response res) -> {
            Numbers numbersModel = new Numbers();

            String[] numberParams = request.queryParamsValues("number");

            List<String> inputNumbers = new ArrayList<>();
            HashMap model = new HashMap();

            model.put("template", "templates/ordenar.vtl");

            if (numberParams != null) {
                inputNumbers.addAll(Arrays.asList(numberParams));
            }
            while (inputNumbers.size() < 6) {
                inputNumbers.add("");
            }
            numbersModel.setNumbers(inputNumbers);
            numbersModel.setRearrangedNumbers(inputNumbers);

            model.put("numbers", numbersModel);

            List<Integer> intList = new ArrayList<>();

            for (String numStr : numbersModel.getNumbers()) {
                try {
                    intList.add(Integer.parseInt(numStr.trim()));
                } catch (NumberFormatException ignored){

                }
            }

            Collections.shuffle(intList);

            List<String> newNumbers = new ArrayList<>();
            for (Integer num : intList) {
                newNumbers.add(num.toString());
            }
            numbersModel.setRearrangedNumbers(newNumbers);

            model.put("numbers", numbersModel);

            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
        };
}
