package org.academiadecodigo.bootcamp.utils;

import java.io.*;

public class Dispatcher {

    private static final String NOT_SUPPORTED_PAGE = "www/WEB-INF/405.html";
    private static final String NOT_FOUND_PAGE = "www/WEB-INF/404.html";


    public static void sendNotSupported(OutputStream outputStream) throws IOException {

        File file = new File(NOT_SUPPORTED_PAGE);

        String header = Helper.constructHeader(file, StatusCode.VERB_NOT_ALLOWED);

        outputStream.write(header.getBytes());

        sendFile(file, outputStream);
    }


    private static void sendFile(File file, OutputStream outputStream) throws IOException {
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));
        byte[] content = new byte[1024];
        int readNumber;

        while ((readNumber = stream.read(content)) != -1) {
            outputStream.write(content, 0, readNumber);
        }

        outputStream.flush();
    }

    public static void sendNotFound(OutputStream outputStream) throws IOException {

        File file = new File(NOT_FOUND_PAGE);

        String header = Helper.constructHeader(file, StatusCode.NOT_FOUND);

        System.out.println("Sending header: " + header);
        outputStream.write(header.getBytes());

        sendFile(file, outputStream);
    }


    public static void sendOkFile(File file, OutputStream outputStream) throws IOException {

        String header = Helper.constructHeader(file, StatusCode.OK);

        outputStream.write(header.getBytes());

        sendFile(file, outputStream);
    }
}
