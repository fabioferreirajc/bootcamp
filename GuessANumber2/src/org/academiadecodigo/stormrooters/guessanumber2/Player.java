package org.academiadecodigo.stormrooters.guessanumber2;

public class Player {

    private String name;


    public Player(String name) {
        this.name = name;
    }

    public int pickANumber(int maxLimit) {

        return Util.getRandom(1, maxLimit);
    }

    public String getName() {
        return name;
    }


}
