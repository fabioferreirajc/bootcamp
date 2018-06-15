package org.academiadecodigo.stormrooters.painter;

import java.io.*;

public class FileManager {


    public void save(String toSave) {
        try {

            FileWriter fileWriter = new FileWriter("save.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(toSave);
            bufferedWriter.close();

        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }


    public String load() {

        String readerResult = "";
        try {


            FileReader fileReader = new FileReader("save.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            readerResult = bufferedReader.readLine();
            bufferedReader.close();


        } catch (IOException ioe) {
            ioe.getMessage();
        }


        return readerResult;
    }


}


