package org.academiadecodigo.stormrooters;

public class Motor extends CarDecorator {

    public Motor(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String getAcessories() {
        return decoratedCar.getAcessories()+" with 2.0L";
    }

    @Override
    public int getPrice() {
        return decoratedCar.getPrice()+ 5000;
    }

}
