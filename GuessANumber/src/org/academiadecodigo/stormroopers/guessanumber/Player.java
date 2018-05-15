package org.academiadecodigo.stormroopers.guessanumber;

public class Player {

    private String name;

    public int pickANumber(int number) {

        return (int) Math.floor(Math.random()*number);
    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }


}
