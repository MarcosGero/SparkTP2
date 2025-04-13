package me.marco.ej4.model;

public class Circulo {
    private double radio;
    private double resultado;

    public Circulo(String radioString) {
        if (radioString == null || radioString.isEmpty()) {
            return;
        }
        double radio = 0;
        try {
             radio = Double.parseDouble(radioString);
        }catch (Exception e){
            return;
        }
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }
    public double getResultado() {
        return resultado;
    }

    public void calcularArea() {
        this.resultado = Math.PI * Math.pow(radio, 2);
    }

    public void calcularPerimetro() {
        this.resultado  = 2 * Math.PI * radio;
    }
}
