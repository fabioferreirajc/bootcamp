package org.academiadecodigo.bootcamp.utils;

import java.io.File;

public class Helper {

    private static MimeHelper mimeHelper = new MimeHelper();

    public static String parseVerb(String request) {

        String[] splitRequest = request.split(" ");

        return splitRequest.length > 0 ? splitRequest[0] : "";
    }

    public static String parseResource(String request) {

        String[] splitRequest = request.split(" ");

        return splitRequest.length > 1 ? splitRequest[1] : "";
    }


    static String constructHeader(File file, StatusCode statusCode) {

        String mimeType = mimeHelper.getMimeType(file);

        return "HTTP/1.0 " + statusCode.getCode() + " " + statusCode + ";\r\n" +
                "Content-Type: " + mimeType + "\r\n" +
                "Content-Length: " + file.length() + "\r\n" +
                "\r\n";
    }
}
