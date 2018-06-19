package org.academiadecodigo.stormrooters;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

    public static void main(String[] args) {
        Server server = new Server();
        server.receive();
    }

    public void receive() {


        int portNumber = 5555;

        byte[] recvBuffer = new byte[1024];

        try {

            DatagramSocket socket = new DatagramSocket(portNumber);

            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);

            socket.receive(receivePacket);
            System.out.println("receive packet");
            String message = new String(recvBuffer).toUpperCase();
            System.out.println(message);

            byte[] sendBuffer;

            sendBuffer = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());

            socket.send(sendPacket);

            socket.close();


        } catch (SocketException se) {
            se.getStackTrace();

        } catch (IOException io) {
            io.getMessage();
        }
    }


}
