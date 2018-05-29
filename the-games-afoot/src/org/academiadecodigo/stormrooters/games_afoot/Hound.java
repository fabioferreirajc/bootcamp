package org.academiadecodigo.stormrooters.games_afoot;

public class Hound {

    private String name;


    public Hound(String name) {
        this.name = name;
    }

    public void chase(Rabbit bugsBunny) {

        if (!bugsBunny.isAlive()) {

            System.out.println("That wabbit is alwaedy dead!");
            return;
        }

        if (bugsBunny.isScared()) {

            System.out.println("That wabbit is alwaedy stawtled! Shoot at it!");
            return;
        }

        bugsBunny.beScared();

        System.out.println("Woof Woof!\nA wabbit just lept out of the bushes! Great job " + name + "!");
    }
}
