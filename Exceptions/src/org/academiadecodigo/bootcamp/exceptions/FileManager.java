package org.academiadecodigo.bootcamp.exceptions;

public class FileManager {

    private boolean login = false;

    private File[] files;
    private int numberOfFiles;

    public FileManager(int numberOfFiles) {
        files = new File[numberOfFiles];
        System.out.println("Number of files " + numberOfFiles);
        this.numberOfFiles = numberOfFiles;
    }


    public void setLogin() {
        this.login = true;
        System.out.println("Login");
    }


    public void setLogout() {
        this.login = false;
        System.out.println("Logout");
    }

    /*
    public File getFile(String fileName) {
        for (int i = 0; i < files.length; i++) {
            if((files[i].getName()).equals(fileName)) {
               return null;
            }
        }

    }
    */

    public void createFile(String fileName) throws NotEnoughSpaceException {
        if (files[numberOfFiles] != null) {
            throw new NotEnoughSpaceException();
        }

        for (int i = 0; i < files.length; i++) {

            if (files[i] == null) {

                files[i] = new File(fileName);
                System.out.println(fileName);
                break;
            }

        }


    }

}



