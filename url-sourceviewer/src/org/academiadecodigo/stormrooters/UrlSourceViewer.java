package org.academiadecodigo.stormrooters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class UrlSourceViewer {

    BufferedReader in;

    public void readContent() {
        try {
            String url2=getUserInput();

            URL url = new URL(url2);

            try {
                in = new BufferedReader(new InputStreamReader(url.openStream()));

                String line = "";
                String content = "";

                while ((line=in.readLine()) != null) {
                    content = content + (line + "\n");
                   // System.out.println(line);
                }

               System.out.println(content);


            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getUserInput() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

}
