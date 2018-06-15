package org.academiadecodigo.stormrooters.readwords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


public class ReadWords implements Iterable<String> {

    private String text = "text.txt";
    private FileReader reader;
    private BufferedReader bReader;

    private String line = "";
    private String[] result;

    private LinkedList<String> words;

    public ReadWords () {
       this.words = new LinkedList<>();
       textReader();
       add();
    }

    public String[] textReader() {


        try {
            FileReader reader = new FileReader(text);
            BufferedReader bReader = new BufferedReader(reader);

            while ((line = bReader.readLine()) != null) {
                result =line.split(" ");
            }
         bReader.close();

        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }

        return result;


    }



    public void add() {
        //String[] singleWords= result.split(" ");
        for (String word:result) {
            words.add(word);
        }
    }

    public int getSize() {
        return words.size();
    }


    @Override
    public Iterator<String> iterator() {
        return words.iterator();

    }
}
