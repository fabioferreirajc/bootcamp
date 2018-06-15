package org.academiadecodigo.stormrooters.readwords;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //ReadWords readWords = new ReadWords();

        ReadLine readLine= new ReadLine();

        for (String word : readLine) {
            System.out.println(word);
        }



    }
}
