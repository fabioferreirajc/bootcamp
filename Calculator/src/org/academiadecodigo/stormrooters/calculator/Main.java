package org.academiadecodigo.stormrooters.calculator;

public class Main {

    public static void main(String[] args) {

        Calculator calc;

        calc = new Calculator("red","texi");

        //calc.colour = "Hot Pink";
        //calc.brand = "Cassio";


        //Calculator calc2 = new Calculator();
        //calc2.colour = "Cardinal Red";
        //calc2.brand = "Texi";

        System.out.println("Calculator is a: " + calc.brand + " of color " + calc.colour);
        //System.out.println("Calculator is a: " + calc2.brand + " of color " + calc2.colour);

        int result = calc.add(66, 2);
        System.out.println(result);


        System.out.println(calc.add(2.12f, 3));

    }

}
