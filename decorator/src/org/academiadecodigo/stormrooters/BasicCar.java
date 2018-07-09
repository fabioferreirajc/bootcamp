package org.academiadecodigo.stormrooters;

public class BasicCar implements Car {

    @Override
    public String getAcessories() {
        return "Basic car";
    }

    @Override
    public int getPrice() {
        return 5000;
    }
}
