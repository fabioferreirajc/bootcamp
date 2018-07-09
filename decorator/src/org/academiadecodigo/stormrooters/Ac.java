package org.academiadecodigo.stormrooters;

public class Ac extends CarDecorator {

    public Ac(Car decoratedCar) {
        super(decoratedCar);

    }

    @Override
    public String getAcessories() {
        return decoratedCar.getAcessories() + " with AC";
    }

    @Override
    public int getPrice() {
        return decoratedCar.getPrice() + 400;
    }
}
