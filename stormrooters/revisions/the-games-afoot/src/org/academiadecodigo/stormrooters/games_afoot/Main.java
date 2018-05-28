package org.academiadecodigo.stormrooters.games_afoot;

public class Main {

    public static void main(String[] args) {

        Rabbit bugsBunny = new Rabbit();
        Rabbit rogerRabbit = new Rabbit();

        Hound pluto = new Hound("Pluto");
        Shotgun bbGun = new Shotgun(2);

        Hunter elmerFudd = new Hunter();
        elmerFudd.setHound(pluto);
        elmerFudd.setShotgun(bbGun);

        elmerFudd.hunt(bugsBunny);
        elmerFudd.hunt(rogerRabbit);

        elmerFudd.hunt(bugsBunny);
    }
}
