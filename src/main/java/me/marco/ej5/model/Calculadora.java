package me.marco.ej5.model;

public class Calculadora {
    private double operando1 = 0;
    private double operando2 = 0;
    private String resultado;
    private String error;

    public Calculadora(String operando1, String operando2) {
        double op1 = 0;
        double op2 = 0;
        if (operando1 == null || operando2 == null) {
            return;
        }
        try {
            op1 = Double.parseDouble(operando1);
        } catch (NumberFormatException e) {
            this.error = "El primer operando no es un número válido.";
        }
        try {
            op2 = Double.parseDouble(operando2);
        } catch (NumberFormatException e) {
            this.error = "El segundo operando no es un número válido.";
        }

        this.operando1 = op1;
        this.operando2 = op2;
    }
    public void sumar() {
        if (this.error != null) {
            return;
        }
        this.resultado = String.valueOf(this.operando1 + this.operando2);
    }
    public void restar() {
        if (this.error != null) {
            return;
        }
        this.resultado = String.valueOf(this.operando1 - this.operando2);
    }
    public void multiplicar() {
        if (this.error != null) {
            return;
        }
        this.resultado = String.valueOf(this.operando1 * this.operando2);
    }
    public String getError() {
        return error;
    }
    public String getResultado() {
        return resultado;
    }
    public void dividir() {
        if (this.error != null) {
            return;
        }
        if (this.operando2 != 0) {
            this.resultado = String.valueOf(this.operando1 / this.operando2);
        } else {
            this.error = "División por cero.";
        }
    }
}
