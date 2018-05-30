package org.academiadecodigo.bootcamp.exceptions;

public class File {

    String fileName;

    public File (String fileName){
        this.fileName=fileName;
    }

    public String getName(){
        return fileName;
    }

}
