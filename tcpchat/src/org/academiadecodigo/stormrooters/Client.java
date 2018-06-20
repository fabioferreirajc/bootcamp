package org.academiadecodigo.stormrooters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Client client = new Client();
        client.send();

    }


    private Socket clientSocket;

    public void send() {
        try {
            String serverIp = "localhost";
            int serverPort = 8001;

            clientSocket = new Socket(serverIp, serverPort);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {

                String messageKeyb = getUserInput();

                if (messageKeyb.equals("close")) {

                    break;
                }

                out.println(messageKeyb);

                System.out.println("SERVER "+in.readLine());

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } finally {
            close();
        }

    }

    private String getUserInput() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    private void close() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}