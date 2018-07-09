package org.academiadecodigo.stormrooters;

public class Main {
    public static void main(String[] args) {

        Car basicCar = new BasicCar();

        System.out.println(basicCar.getAcessories() + " and it costs " + basicCar.getPrice());

        Car carWithAC = new Ac(basicCar);

        System.out.println(carWithAC.getAcessories() + " and it costs " + carWithAC.getPrice());


        Car carWithMotor = new Motor(carWithAC);


    }
}
