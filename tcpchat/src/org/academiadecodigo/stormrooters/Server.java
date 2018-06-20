package org.academiadecodigo.stormrooters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        Server server = new Server();
        server.receive();

    }

    private int listningPort = 8001;
    private Socket clientSocket;
    private ServerSocket serverSocket;


    public void receive() {
        try {
            serverSocket = new ServerSocket(listningPort);
            clientSocket = serverSocket.accept();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (!clientSocket.isClosed()) {

                String messageFromClient = in.readLine();

                if (messageFromClient.equals("close")) {
                    System.out.println("Client down");
                    clientSocket.close();
                    break;
                }


                System.out.println("CLIENT " + messageFromClient);
                String messageKeyb = getUserInput();

                out.println(messageKeyb);

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
            serverSocket.close();
            receive();
        } catch (IOException e) {
            System.err.println(e.getMessage());

        }
    }


}
