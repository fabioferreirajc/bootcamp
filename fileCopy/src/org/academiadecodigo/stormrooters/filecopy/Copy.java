package org.academiadecodigo.stormrooters.filecopy;

import java.io.*;

public class Copy {

    private FileOutputStream outputStream;
    private FileInputStream inputStream;

    String file;

    public Copy(String file) {
        this.file = file;
    }


    public void copy() {

        try {
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream("txt/text2.txt");

            byte[] savedBytes = new byte[1024];
            int read = inputStream.read(savedBytes);

            while (read != -1) {

                outputStream.write(savedBytes, 0, read);
                read = inputStream.read(savedBytes);

            }


        } catch (FileNotFoundException e) {
            e.getMessage();
            System.out.println("can not read");
        } catch (IOException e) {
            e.getMessage();
            System.out.println("can not read");
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            }
            catch (IOException e) {e.getMessage();}
        }


    }
}








