package me.marco.ej2.model;

public class IMC {
    private String peso;
    private String altura;
    private double imc;
    private String resultado;

    public IMC(String peso, String altura) {

        if (peso == null || peso.isEmpty() || altura == null || altura.isEmpty()) {
            this.imc = 0;
            this.resultado = "";
            this.peso = "";
            this.altura = "";
            return;
        }
        this.peso = peso;
        this.altura = altura;
        calcularIMC();
    }

    private void calcularIMC() {
        double pesoDouble = Double.parseDouble(peso);
        double alturaDouble = Double.parseDouble(altura);
        this.imc = pesoDouble / (alturaDouble * alturaDouble);

        if (imc < 18.5) {
            resultado = "Bajo peso";
        } else if (imc < 24.9) {
            resultado = "Peso normal";
        } else if (imc < 29.9) {
            resultado = "Sobrepeso";
        } else {
            resultado = "Obesidad";
        }
    }

    public String getPeso() {
        return peso;
    }

    public String getAltura() {
        return altura;
    }

    public double getImc() {
        return imc;
    }

    public String getResultado() {
        return resultado;
    }
}
