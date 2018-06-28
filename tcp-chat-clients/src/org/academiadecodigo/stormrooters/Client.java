package org.academiadecodigo.stormrooters;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {

        Client client = new Client();

        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        fixedPool.submit(new readerSender());
    }




    private class readerSender implements Runnable {

        public readerSender() {
            try {
                Socket clientSocket = new Socket("localhost", 8080);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String imputText = getUserInput();
            sendToServer(imputText);
        }

    }


    private void sendToServer(String imputText) {


    }

    private String getUserInput() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}
