package org.academiadecodigo.stormrooters;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private LinkedList clientsList;

    public void startServer() {
        try {

            serverSocket = new ServerSocket(8080);
            ExecutorService cachedPool = Executors.newCachedThreadPool();
            clientsList=new LinkedList();

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("new client");
                cachedPool.submit(new ClientThread(clientSocket));
                clientsList.add(cachedPool);
                System.out.println("Client to ClientThread");



            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
