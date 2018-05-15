package org.academiadecodigo.stormroopers.guessanumber;

public class Main {

    public static void main(String[] args) {

        Game newGame = new Game();

        newGame.setMaxLimit(30);

        Player newPlayer = new Player();
        Player newPlayer2 = new Player();

        newPlayer.setName("Fábio");
        newPlayer2.setName("Pedro");

        Player[] players = {newPlayer, newPlayer2};

        newGame.setPlayers(players);


        newGame.start();

    }
}
