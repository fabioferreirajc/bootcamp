package org.academiadecodigo.stormroopers.guessanumber;

public class Player {

    private String name;

    public int pickANumber(int maxLimit) {

        return Generator.generator(maxLimit);
    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }


}
