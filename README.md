# SparkTP2

This is a Java web application project built using the [Spark Framework](https://sparkjava.com/). It contains a series of practical exercises (Trabajo Práctico 2) demonstrating basic web routing, parameter handling, and simple logic implementations.

## Technologies Used

- **Java 17**
- **Maven**
- **Spark Framework** (2.9.4)
- **Gson** (2.12.1) - For JSON serialization
- **Apache Velocity** - For templating
- **SLF4J & Logback** - For logging

## Exercises Overview

The project is divided into several exercises, each with its own package under `src/main/java/me/marco/` and its own `Main` class to start the server:

- **Ejercicio 1 (Sorting Numbers):** `Ej1Main.java`
  - `/ej1/ordenar`: Sorts a given list of numbers.
  - `/ej1/desordenar`: Unsorts a given list of numbers.
  
- **Ejercicio 2 (IMC Calculator):** `Ej2Main.java`
  - `/ej2/imc`: Calculates the Body Mass Index (IMC/BMI).

- **Ejercicio 3 (Family Relationships):** `Ej3Main.java`
  - Endpoints to query family trees: `/ej3/persona`, `/ej3/personas`, `/ej3/hijos`, `/ej3/hermanos`, `/ej3/nietos`, `/ej3/padres`, `/ej3/tios`, `/ej3/sobrinos`.

- **Ejercicio 4 (Circle Calculations):** `Ej4Main.java`
  - `/ej4`: Circle view.
  - `/ej4/area`: Calculates the area of a circle.
  - `/ej4/perimetro`: Calculates the perimeter of a circle.

- **Ejercicio 5 (Calculator):** `Ej5Main.java`
  - A basic calculator with endpoints for basic math operations: `/ej5`, `/ej5/sumar`, `/ej5/restar`, `/ej5/multiplicar`, `/ej5/dividir`.

- **Ejercicio 6 (Converter):** `Ej6Main.java`
  - A utility for unit conversions: `/ej6`, `/ej6/calcular`.

- **Ejercicio 7 (Grido Points):** `Ej7Main.java`
  - A points redemption system simulation for Grido ice cream: `/ej7/grido`, `/ej7/grido/verificar`.

## Running the Application

To run the application, you need to execute the `main` method of the exercise you want to test. 

For example, to run Exercise 1, execute `me.marco.ej1.Ej1Main`.

By default, Spark applications run on port `4567`. You can access the specific endpoints in your browser or via a tool like Postman at `http://localhost:4567/`.
