package org.academiadecodigo.stormrooters.guessanumber2;

public class Main {

    public static void main(String[] args) {

        Game newGame = new Game();
        Player[] players = {

                new Player("A"),
                new Player("B"),
                new Player("C"),
                new Player("D"),
                new Player("E"),
                new Player("F"),
                new Player("Ga nbozino")

        };

        newGame.setPlayers(players);

        newGame.setMaxLimit(20);

        newGame.start();

    }

}
