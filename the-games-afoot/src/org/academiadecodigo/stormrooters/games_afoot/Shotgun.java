package org.academiadecodigo.stormrooters.games_afoot;

public class Shotgun {

    private int numberOfShells;


    public Shotgun(int numberOfShells) {

        this.numberOfShells = numberOfShells;
    }

    public void shoot(Rabbit bugsBunny) {

        if (numberOfShells <= 0) {

            System.out.println("I'm out of shells. Better gwab some mowe fiwst");
            return;
        }

        if (!bugsBunny.isAlive()) {

            System.out.println("That wabbit is alwaedy dead!");
            return;
        }

        if (!bugsBunny.isScared()) {

            System.out.println("Which wabbit? Maybe I should send pluto oveg...");
            return;
        }

        numberOfShells--;

        bugsBunny.dye();

        System.out.println("Pew Pew!\nI just shot a wabbit!");
        System.out.println("I have " + numberOfShells + " shells left.");
    }
}
