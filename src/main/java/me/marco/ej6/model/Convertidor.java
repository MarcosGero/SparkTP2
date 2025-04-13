package me.marco.ej6.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

public class Convertidor {
    private String tipo;
    private String unidadOrigen;
    private String valor;
    private double valorNum;
    private HashMap<String, Double> resultados;
    private String error;



    public Convertidor(String tipo, String valor) {
        if(tipo == null || tipo.isEmpty()) {
            this.error = "El tipo de convertidor no puede estar vacio";
            this.tipo = null;

            return;
        }
        if(valor != null && !valor.isEmpty()) {
            try {
                this.valorNum = Double.parseDouble(valor);
                this.valor = valor;
            } catch (NumberFormatException e) {
                this.error = "El valor no es un numero valido";
                this.valor = null;
                return;
            }
        } else {
            this.valor = null;
        }

        if(!tipo.equalsIgnoreCase("temperatura") && !tipo.equalsIgnoreCase("longitud") && !tipo.equalsIgnoreCase("peso")) {
            this.error = "El tipo de convertidor no es valido";
            this.tipo = null;
            return;
        }
        this.tipo = tipo;
    }
    public void convertir() {
        this.resultados = switch (tipo.toLowerCase()) {
            case "temperatura" -> convertirTemperatura(valorNum, unidadOrigen);
            case "longitud" -> convertirLongitud(valorNum, unidadOrigen);
            case "peso" -> convertirPeso(valorNum, unidadOrigen);
            default -> new HashMap<>();
        };
    }
    private static HashMap<String, Double> convertirTemperatura(double valor, String origen) {
        HashMap<String, Double> resultados = new HashMap<>();

        switch (origen.toLowerCase()) {
            case "celsius" -> {
                resultados.put("Fahrenheit", redondear((valor * 9/5) + 32));
                resultados.put("Kelvin", redondear(valor + 273.15));
            }
            case "fahrenheit" -> {
                resultados.put("Celsius", redondear((valor - 32) * 5/9));
                resultados.put("Kelvin", redondear((valor - 32) * 5/9 + 273.15));
            }
            case "kelvin" -> {
                resultados.put("Celsius", redondear(valor - 273.15));
                resultados.put("Fahrenheit", redondear((valor - 273.15) * 9/5 + 32));
            }
        }
        return resultados;
    }
    private static double redondear(double valor) {
        return BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
    private static HashMap<String, Double> convertirLongitud(double valor, String origen) {
        HashMap<String, Double> resultados = new HashMap<>();

        switch (origen.toLowerCase()) {
            case "metros" -> {
                resultados.put("Kilometros", redondear(valor / 1000));
                resultados.put("Millas", redondear(valor * 0.000621371));
                resultados.put("Pies", redondear(valor * 3.28084));
            }
            case "kilometros" -> {
                resultados.put("Metros", redondear(valor * 1000));
                resultados.put("Millas", redondear(valor * 0.621371));
                resultados.put("Pies", redondear(valor * 3280.84));
            }
            case "millas" -> {
                resultados.put("Metros", redondear(valor * 1609.34));
                resultados.put("Kilometros", redondear(valor * 1.60934));
                resultados.put("Pies",redondear( valor * 5280));
            }
            case "pies" -> {
                resultados.put("Metros", redondear(valor * 0.3048));
                resultados.put("Kilometros", redondear(valor * 0.0003048));
                resultados.put("Millas", redondear(valor * 0.000189394));
            }
        }
        return resultados;
    }

    private static HashMap<String, Double> convertirPeso(double valor, String origen) {
        HashMap<String, Double> resultados = new HashMap<>();

        switch (origen.toLowerCase()) {
            case "kilogramos" -> {
                resultados.put("Gramos", redondear(valor * 1000));
                resultados.put("Libras", redondear(valor * 2.20462));
                resultados.put("Onzas", redondear(valor * 35.274));
            }
            case "gramos" -> {
                resultados.put("Kilogramos", redondear(valor / 1000));
                resultados.put("Libras", redondear(valor * 0.00220462));
                resultados.put("Onzas", redondear(valor * 0.035274));
            }
            case "libras" -> {
                resultados.put("Kilogramos", redondear(valor * 0.453592));
                resultados.put("Gramos", redondear(valor * 453.592));
                resultados.put("Onzas", redondear(valor * 16));
            }
            case "onzas" -> {
                resultados.put("Kilogramos", redondear(valor * 0.0283495));
                resultados.put("Gramos", redondear(valor * 28.3495));
                resultados.put("Libras", redondear(valor * 0.0625));
            }
        }
        return resultados;
    }
    //Methods for getting options for the conversion
    public List<String> getOptions(){
        return switch (tipo.toLowerCase()) {
            case "temperatura" -> List.of("celsius", "fahrenheit", "kelvin");
            case "longitud" -> List.of("metros", "kilometros", "millas", "pies");
            case "peso" -> List.of("kilogramos", "gramos", "libras", "onzas");
            default -> null;
        };
    }


    public String getUnidadOrigen() {
        return unidadOrigen;
    }

    public void setUnidadOrigen(String unidadOrigen) {
        this.unidadOrigen = unidadOrigen;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public HashMap<String, Double> getResultados() {
        return resultados;
    }

    public void setResultados(HashMap<String, Double> resultados) {
        this.resultados = resultados;
    }

    public String getError() {
        return error;
    }
}
