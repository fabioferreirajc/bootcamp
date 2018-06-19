package org.academiadecodigo.stormrooters.inetadress;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        String host = getUserInput();

        Inet inet = new Inet();

        inet.local();

        inet.getIpAndTest("www.wikipedia.org",100);

    }


    /*

    private static String getUserInput() {

        Scanner scanner = new Scanner(System.in);
        String question = "?";
        System.out.println(question);
        return scanner.nextLine();

    }*/


}
