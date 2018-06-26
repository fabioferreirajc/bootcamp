package org.academiadecodigo.bootcamp;

public class Main {


    public static void main(String[] args) {

        WebServer webServer = new WebServer(8080);

        webServer.start();
    }
}
