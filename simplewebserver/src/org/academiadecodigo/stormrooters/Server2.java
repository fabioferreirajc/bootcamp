package org.academiadecodigo.stormrooters;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    private int listningPort = 8889;
    private ServerSocket serverSocket;
    private Socket client;

    private BufferedReader in;
    private PrintWriter out;
    private DataOutputStream dataOut;
    private File file;
    private int fileSize;

    public void prepareServer() {
        try {
            serverSocket = new ServerSocket(listningPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {

        while (true) {
            try {

                client = serverSocket.accept();

                in = new BufferedReader(new InputStreamReader(client.getInputStream()));


                dataOut = new DataOutputStream(client.getOutputStream());


                String requestFromBrowser = in.readLine();
                System.out.println("Request from browser | " + requestFromBrowser);

                String[] splitedReq = requestFromBrowser.split(" ");
                String requestSource = splitedReq[1];
                //System.out.println("Source requested | " + requestSource);


                file = new File("source" + requestSource);
                fileSize = (int) file.length();
                System.out.println(file.length());

                byte[] savedBytes = new byte[fileSize];

                if (requestFromBrowser.contains("favicon.ico")) {
                    client.close();
                    continue;
                }

                if (requestFromBrowser.contains(".html")) {
                    System.out.println("html file");
                    headerResponseHtml();
                }

                if (requestFromBrowser.contains(".jpg")) {
                    System.out.println("jpg file");
                    headerResponseImg();
                }


                FileInputStream readFile = new FileInputStream(file);
                readFile.read(savedBytes);
                readFile.close();

                System.out.println("file bytes " + savedBytes[5]);


                dataOut.write(savedBytes);
                client.close();


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void headerResponseHtml() {
        try {
            dataOut.writeBytes("HTTP/1.0 200 Document Follows\r\n" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "Content-Length: " + fileSize + "\r\n\r\n");
            dataOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void headerResponseImg() {
        try {
            dataOut.writeBytes("HTTP/1.0 200 Document Follows\r\n" +
                    "Content-Type: image/jpg \r\n" +
                    "Content-Length: " + fileSize + "\r\n\r\n");
            dataOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void headerNotFout(){
        try {
            dataOut.writeBytes("HTTP/1.0 404 Not Found\n" +
                    "Content-Type: text/html; charset=UTF-8\\r\\n\n" +
                    "Content-Length: <file_byte_size> \\r\\n\n" +
                    "\\r\\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
