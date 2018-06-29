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
        Socket clientSocket = new Socket("localhost", 8080);

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        Scanner scanner = new Scanner(System.in);

        //ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        //fixedPool.submit(new Send(clientSocket));

        Thread sendThread = new Thread(new Send(clientSocket, out, in));

    }

    private class Send implements Runnable {
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;

        public Send(Socket clientsocket, PrintWriter out, BufferedReader in) {
            this.clientSocket = clientsocket;
            this.out = out;
            this.in = in;
        }

        @Override
        public void run() {
            String message = getUserInput();
            out.println(message);
            System.out.println(message);
        }
    }


    private class Read implements Runnable {
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;

        public Read(Socket clientsocket, PrintWriter out, BufferedReader in) {
            this.clientSocket = clientsocket;
            this.out = out;
            this.in = in;
        }

        @Override
        public void run() {
            String messageFromServer;
            try {
                messageFromServer = in.readLine();
                System.out.println(messageFromServer);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    /*
    private class Send implements Runnable {

        private Socket clientSocket;
        PrintWriter out;
        BufferedReader in;

        public Send(Socket clientsocket) {
            this.clientSocket = clientsocket;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            while (true) {
                String clientMessage = getUserInput();
                out.println(clientMessage);
            }
        }
    }
    */

    private String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}