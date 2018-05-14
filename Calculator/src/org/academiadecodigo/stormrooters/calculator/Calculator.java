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

    public void setColour(String colour) {
        String[] colours = {"Red","Blue"};
        for (String validColour: colours){
            if (validColour.equals(colour)){
                this.colour=colour;
            }
        }
    }

    // public Calculator() {}


    public int add(int a, int b) {

        return a + b;

    }

    public float add(float a, float b) {

        return a + b;

    }


}
