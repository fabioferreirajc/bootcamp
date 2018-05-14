package org.academiadecodigo.stormrooters.calculator;

public class Main {

    public static void main(String[] args) {

        Calculator calc;

        calc = new Calculator("Casio","Blue");

        //calc.colour = "Hot Pink";
        //calc.brand = "Cassio";


        //Calculator calc2 = new Calculator();
        //calc2.colour = "Cardinal Red";
        //calc2.brand = "Texi";

        System.out.println("Calculator is a: " + calc.getBrand() + " of color " + calc.getColour());
        //System.out.println("Calculator is a: " + calc2.brand + " of color " + calc2.colour);

        calc.setBrand("Texas");
        System.out.println("new brand: " + calc.getBrand());





        int result = calc.add(66, 2);
        System.out.println(result);


        System.out.println(calc.add(2.12f, 3));

    }

}
