package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class CarFactory {


    public static Car getNewCar() {

        Position position = new Position();

        int typeOfCar = (int) (Math.floor(Math.random() * 2));

        if (typeOfCar == 0) {
            return new Fiat(position);
        }


        return new Mustang(position);


    }
}