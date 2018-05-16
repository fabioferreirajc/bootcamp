package org.academiadecodigo.stormrooters.guessanumber;

public class Game {


    private int maxLimit;
    private Player[] players;


    public void start() {

        int numberGame = Generator.generator(maxLimit);

        System.out.println("game picked: " + numberGame);

        int response;

        boolean gameOn = true;

        while (gameOn) {

            for (int i = 0; i < players.length; i++) {

                response = players[i].pickANumber(maxLimit);
                System.out.println("Player " + players[i].getName() + " respond " + response);


                if (numberGame == response) {
                    System.out.println(players[i].getName() + " win the game");
                    gameOn = false;
                    break;

                }
            }
        }

        /* Game for 1 player.
        while (gameOn) {


            response = players[1].pickANumber(maxLimit);

            System.out.println("player picked: " + response);


            if (response == numberGame) {

                System.out.println(players[1].getName() + " picked number " + response + " and was correct");

                gameOn = false;

                break;
            }

            System.out.println("please choose another number");
            */
    }


    public void setPlayers(Player[] players) {
        this.players = players;

    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }


}
