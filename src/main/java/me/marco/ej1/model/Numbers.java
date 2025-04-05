package me.marco.ej1.model;


import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<String> numbers;
    private List<String> rearrangedNumbers;
    private String errorMessage;

    public Numbers() {
        numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add("");
        }
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getRearrangedNumbers() {
        return rearrangedNumbers;
    }

    public void setRearrangedNumbers(List<String> rearrangedNumbers) {
        this.rearrangedNumbers = rearrangedNumbers;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}