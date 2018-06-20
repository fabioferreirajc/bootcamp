package org.academiadecodigo.stormrooters;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Client client = new Client();
        String messageKeyb = getUserInput();
        client.send(messageKeyb);
    }


    private String hostName = "192.168.1.15";



    int portNumber = 5555;

    byte[] sendBuffer;

    private static String getUserInput() {

        Scanner scanner = new Scanner(System.in);
        String question = "?";
        System.out.println(question);
        return scanner.nextLine();

    }

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

            String returnetMessage = new String(recvBuffer);

            System.out.println(returnetMessage.trim());


        } catch (SocketException se) {
            se.printStackTrace();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

}
