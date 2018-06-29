package org.academiadecodigo.stormrooters;

import java.io.*;
import java.net.Socket;

public class ClientThread implements Runnable {

    Socket clientSocket;
    BufferedReader clientImputReader;
    DataOutputStream output;

    public ClientThread(Socket clientSocket) {

        this.clientSocket = clientSocket;
        try {

            clientImputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            output = new DataOutputStream(clientSocket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String readClientMessage = clientImputReader.readLine();
            System.out.println(readClientMessage);

            if (readClientMessage.equals("close")) {
                System.out.println("Client down");
                clientSocket.close();
                return;
            }

            output.writeChars(readClientMessage.toUpperCase());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientImputReader.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
