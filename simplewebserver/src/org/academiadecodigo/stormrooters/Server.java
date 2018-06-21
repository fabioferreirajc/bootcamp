package org.academiadecodigo.stormrooters;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int listningPort = 7777;
    private ServerSocket serverSocket;
    private Socket browser;

    private FileReader fileReader;
    private BufferedReader bFileReader;

    private PrintWriter out;
    private String fileType;
    private File file;


    public void receive() {
        try {
            serverSocket = new ServerSocket(listningPort);
            browser = serverSocket.accept();
            System.out.println("Browser connected.");

            out = new PrintWriter(browser.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(browser.getInputStream()));


            String requestSource = in.readLine();
            System.out.println(requestSource);

            file = new File("source/index.html");


            fileReader = new FileReader(file);
            bFileReader = new BufferedReader(fileReader);


            if (file.exists()) {
                headerResponseOk(getFileLength(file), getFileType(file));
                System.out.println("File founded.");
            }


            String line = "";
            String content = "";

            while ((line = bFileReader.readLine()) != null) {
                content = content + (line + "\n");
            }

            out.println(content); //to browser


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                browser.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void headerResponseOk(Long fileSize, String fileType) {
        out.println("HTTP/1.0 200 Document Follows\r\n" +
                "Content-Type: " + fileType + "; charset=UTF-8\r\n" +
                "Content-Length: " + fileSize
        );
    }


    private String getFileType(File file) {
        MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();
        return mimetypesFileTypeMap.getContentType(file);
    }

    private Long getFileLength(File file) {
        return file.length();
    }
}



