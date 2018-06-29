package org.academiadecodigo.stormrooters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.startClient();

    }


    public void startClient() throws IOException {

        Socket clientSocket = new Socket("localhost", 8081);

        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        fixedPool.submit(new Sender(clientSocket));
        fixedPool.submit(new Reader(clientSocket));

    }

    private String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    private class Sender implements Runnable {
        Socket clientSocket;
        PrintWriter out;

        public Sender(Socket clientsocket) {

            this.clientSocket = clientsocket;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {

                String message = getUserInput();
                out.println(message);
            }
        }
    }


    private class Reader implements Runnable {
        Socket clientSocket;
        BufferedReader in;

        public Reader(Socket clientsocket) {
            this.clientSocket = clientsocket;
            try {
                in= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String messageFromServer;
            try {
                while(true) {
                messageFromServer = in.readLine();
                System.out.println(messageFromServer);}
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}