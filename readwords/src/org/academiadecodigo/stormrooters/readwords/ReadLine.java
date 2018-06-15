package org.academiadecodigo.stormrooters.readwords;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class ReadLine implements Iterable<String> {

    private FileReader reader;
    private BufferedReader bReader;
    private String line = "";

    private String[] result;

    public ReadLine() {

        String text = "/Users/codecadet/Desktop/bootcamp/readwords/text.txt";

        try {
            this.reader = new FileReader(text);
            this.bReader = new BufferedReader(reader);

        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }

    @Override
    public Iterator<String> iterator() {


        return new Iterator<String>() {

            private int indexCounter=-1;


            @Override
            public boolean hasNext() {

                try {

                    if (result!=null && indexCounter < result.length - 1) {

                        System.out.println("INDEX COUNTER " + indexCounter);
                        return true;
                    }

                    if ((line = bReader.readLine()) != null) {
                        indexCounter=-1;
                        result = line.split(" ");
                    }

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    ioe.getMessage();
                }
                return indexCounter < result.length - 1;
            }


            @Override
            public String next() {

                indexCounter++;
                return  result[indexCounter];
            }
        };
    }
}
