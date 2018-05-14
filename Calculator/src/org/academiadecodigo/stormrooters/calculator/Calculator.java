package org.academiadecodigo.stormrooters.calculator;

public class Calculator {

    public String brand;
    public String colour;


    public Calculator(String brand, String colour) {

      this.brand = brand;
      this.colour = colour;

      //System.out.println("Calculator is a: " + brand + " of color " + colour);

    }



    // public Calculator() {}


    public int add(int a, int b) {

        return a + b;

    }

    public float add(float a, float b) {

        return a + b;

    }


}
