package org.academiadecodigo.stormrooters.calculator;

public class Calculator {

    private String brand;
    private String colour;


    public Calculator(String brand, String colour) {

      this.brand = brand;
      this.colour = colour;

      //System.out.println("Calculator is a: " + brand + " of color " + colour);

    }

    public String getBrand() {
        return brand;
    }

    public String getColour() {
        return colour;
    }


    public void setBrand( String brand) {
        String[] brands = {"Casio","Texas"};
        for (String validBrand: brands){
            if (validBrand.equals(brand)){
                this.brand=brand;
            }

            }
        }
    }
    int counter=0;
    public void setColour(String colour) {
        String[] colours = {"Red","Blue"};
        for (String validColour: colours){
            if (validColour.equals(colour)){
                this.colour=colour;
                counter++;
            }
            else{if (counter==2){
                System.out.println("teste");
            }}
        }
    }

    // public Calculator() {}


    public double add(double a, double b) {

        return a + b;

    }

    public double sub(double a, double b) {

        return a - b;

    }

    public double mult(double a, double b) {

        return a * b;

    }

    public double div(double a, double b) {

        return a / b;

    }
/*
    public float add(float a, float b) {

        return a + b;

    }
*/

}
