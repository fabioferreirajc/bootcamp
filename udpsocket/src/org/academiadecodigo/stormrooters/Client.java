package org.academiadecodigo.stormrooters;

import java.io.IOException;
import java.net.*;

public class Client {

    public static void main(String[] args) {

        Client client = new Client();
        client.send("teste");
    }


    String hostName = "192.168.1.15";
    int portNumber = 5555;

    byte[] sendBuffer;


    public void send(String message) {
        try {

            DatagramSocket socket = new DatagramSocket();
            System.out.println("Datagram client");

            sendBuffer = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(hostName), portNumber);
            System.out.println("client sendpacket");
            socket.send(sendPacket);


            byte[] recvBuffer = new byte[1024];
            DatagramPacket recvPacket = new DatagramPacket(recvBuffer, recvBuffer.length);
            socket.receive(recvPacket);

            System.out.println(new String (recvPacket.getData()).trim());



        } catch (SocketException se) {
            se.getMessage();

        } catch (IOException ioe) {
            ioe.getMessage();
        }


    }

}
