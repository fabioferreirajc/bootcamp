package org.academiadecodigo.stormrooters.sniper;

public class Main {
    public static void main(String[] args) {


        SniperRifle simoHayha = new SniperRifle("Simo Hayha");
        Game newGame= new Game (5,simoHayha);

        System.out.println("NUMBER OF GAME OBJECTS  " + newGame.getGameObjectsSize());

        newGame.start();
    }
}
