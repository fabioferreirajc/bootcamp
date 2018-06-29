package org.academiadecodigo.stormrooters;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private LinkedList<ClientThread> clientsList;


    public void startServer() {
        try {

            serverSocket = new ServerSocket(8081);
            ExecutorService cachedPool = Executors.newCachedThreadPool();
            clientsList = new LinkedList<>();

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("new client");

                ClientThread ct = new ClientThread(clientSocket);
                clientsList.add(ct);
                cachedPool.submit(ct);

                //if (ct.readClientMessage!=null){
                //ct.sendMessage();}
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private class ClientThread implements Runnable {

        Socket clientSocket;
        BufferedReader clientInputReader;
        DataOutputStream output;


        public ClientThread(Socket clientSocket) {

            this.clientSocket = clientSocket;

            try {
                clientInputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                output = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            try {
                while (true) {
                    String readClientMessage;
                    readClientMessage = clientInputReader.readLine()+"\n";
                    System.out.println(readClientMessage);

                    for (ClientThread clientThread : clientsList) {
                        clientThread.sendMessage(readClientMessage);
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();

            }

        }

        public void sendMessage(String readClientMessage) {
            try {
                output.writeBytes(readClientMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
