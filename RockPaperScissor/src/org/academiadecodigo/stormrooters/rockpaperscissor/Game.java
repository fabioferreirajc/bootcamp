package org.academiadecodigo.stormrooters.rockpaperscissor;

public class Game {

    private Player[] players;

    private int maxRounds = 0;


    public void startGame() {


            Hand player1 = players[0].chooseHand();
            Hand player2 = players[1].chooseHand();
            System.out.println("Player 1 " + player1);
            System.out.println("Player 2 " + player2);



            switch (player1) {


                case ROCK:
                    if (player2 == Hand.SCISSOR) {
                        System.out.println("Player 1 Wins!!");
                        players[0].setRoundsWon();
                        break;
                    }
                    players[1].setRoundsWon();
                    System.out.println("Player 2 Wins!!");
                    break;

                case PAPER:
                    if (player2 == Hand.ROCK) {
                        System.out.println("Player 1 Wins!!");
                        players[0].setRoundsWon();
                        break;
                    }
                    players[1].setRoundsWon();
                    System.out.println("Player 2 Wins!!");
                    break;

                case SCISSOR:
                    if (player2 == Hand.PAPER) {
                        System.out.println("Player 1 Wins!!");
                        players[0].setRoundsWon();
                        break;
                    }
                    players[1].setRoundsWon();
                    System.out.println("Player 2 Wins!!");
                    break;

            }


    }


    public void setPlayers(Player[] players) {

        this.players = players;
    }

    public void setMaxRounds(int maxRounds) {
        this.maxRounds = maxRounds;
    }

}
