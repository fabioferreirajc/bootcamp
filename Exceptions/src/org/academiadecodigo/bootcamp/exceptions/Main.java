package org.academiadecodigo.bootcamp.exceptions;

public class Main {

    public static void main(String[] args) {


        FileManager fileManager= new FileManager(3);
        fileManager.setLogin();


        try {
            fileManager.createFile("a");
            fileManager.createFile("b");
            //fileManager.createFile("c");
           // fileManager.createFile("d");

        } catch (NotEnoughSpaceException space) {
            System.out.println(space.getMessage());
        }
    }
}
