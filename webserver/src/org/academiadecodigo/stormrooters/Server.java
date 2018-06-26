package org.academiadecodigo.stormrooters;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int listningPort = 8890;
    private ServerSocket serverSocket;
    private Socket client;
    private BufferedReader in;
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
                System.out.println(requestFromBrowser);

                String[] splitedReq = requestFromBrowser.split(" ");
                String requestSource = splitedReq[1];

                file = new File("source" + requestSource);

                if (!file.exists()) {
                    headerNotFount();
                   continue;
                }

                fileSize = (int) file.length();

                byte[] savedBytes = new byte[fileSize];

                if (requestFromBrowser.contains("favicon.ico")) {
                    client.close();
                    continue;
                }
                if (requestFromBrowser.contains(".html")) {
                    headerResponseHtml();
                }
                if (requestFromBrowser.contains(".jpg")) {
                    headerResponseImg();
                }

                FileInputStream readFile = new FileInputStream(file);
                readFile.read(savedBytes);
                readFile.close();

                dataOut.write(savedBytes);

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

    private void headerNotFount() {
        try {
            dataOut.writeBytes("HTTP/1.0 404 Not Found" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "Content-Length: <file_byte_size> \r\n\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}