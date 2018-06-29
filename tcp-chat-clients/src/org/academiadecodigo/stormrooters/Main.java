package org.academiadecodigo.stormrooters;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();

        Client client = new Client();
    }
}
