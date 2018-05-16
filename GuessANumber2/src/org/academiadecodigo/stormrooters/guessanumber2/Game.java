package org.academiadecodigo.stormrooters.guessanumber2;

public class Game {
    private Player[] players;
    private int maxLimit;


    public void start() {

        //game logic
        //first game pick a number and store it
        //ask the player to pick a number
        //game compare de number
        //If they are the same the player win
        //ask bext player

        int systemGuess = Util.getRandom(1, maxLimit);
        System.out.println("GAme number is" + systemGuess);

        boolean endGame = false;

        while (!endGame) {
            for (Player player : players) {

                int playerGuess = player.pickANumber(maxLimit);

                System.out.println("player " + player.getName() + " guesses " + playerGuess);

                if (playerGuess == systemGuess) {
                    System.out.println(" Winner is " + player.getName());
                    endGame = true;

                    break;

                }

            }
        }

    }


    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

}
