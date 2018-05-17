package org.academiadecodigo.stormrooters.rockpaperscissor;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        Player[] players = {

                new Player("Fábio"),
                new Player("Ruben"),

        };


        game.setPlayers(players);

        game.setMaxRounds(5);

        game.startGame();



    }
}
