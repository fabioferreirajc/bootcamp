package org.academiadecodigo.stormroopers.guessanumber;

public class Game {


    private int maxLimit;
    private Player[] players;


    public void start() {

        int numberGame = (int) Math.floor(Math.random() * maxLimit);

        System.out.println("game picked: " + numberGame);

        boolean gameOn = true;

        while (gameOn) {

            int response = players[0].pickANumber(maxLimit);

            System.out.println("player picked: " + response);

            if (response == numberGame) {

                System.out.println(players[0].getName() + " picked number " + response + " and was correct");

                gameOn = false;

                break;
            }

            System.out.println("please choose another number");
        }


    }

    public void setPlayers(Player[] players) {
        this.players = players;

    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }


}
