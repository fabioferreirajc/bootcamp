package org.academiadecodigo.stormrooters.rockpaperscissor;

public class Player {

    private String name;
    private int roundsWon;

    public Player(String name) {

        this.name = name;
    }



    public Hand chooseHand() {
        Hand[] hands= Hand.values();

        return hands[(int)(Math.floor(Math.random()*3))];

                // (int) (Math.random() * 2 - 0 + 1) + 0

    }


    public void setRoundsWon() {
        this.roundsWon++;
    }


  /*  public void setName (String name) {

        this.name=name;
    }
  */



}
