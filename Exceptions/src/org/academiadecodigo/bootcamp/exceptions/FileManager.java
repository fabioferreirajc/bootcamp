package org.academiadecodigo.bootcamp.exceptions;

public class FileManager {

    private boolean login = false;

    private File[] files;

    public FileManager(int numberOfFiles) {
        File[] files = new File[numberOfFiles];
        System.out.println("Number of files " + numberOfFiles);
    }


    public void setLogin() {
        this.login = true;
        System.out.println("Login");
    }


    public void setLogout() {
        this.login = false;
        System.out.println("Logout");
    }


    public File getFile(String fileName) {
        for (int i = 0; i < files.length; i++) {
            if((files[i].getName()).equals(fileName)) {

            }
        }

    }


    public void createFile(String fileName) {
        for(int i=0;i<files.length;i++) {
            files[i] = new File(fileName);

        }
    }

}


