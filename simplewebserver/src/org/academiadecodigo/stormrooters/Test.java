package org.academiadecodigo.stormrooters;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;

public class Test {


    public static void main(String[] args) {

        MimetypesFileTypeMap typeMap = new MimetypesFileTypeMap();

        File file = new File("pic.png");

        typeMap.addMimeTypes("image/png png");


        System.out.println(typeMap.getContentType(file));



    }
}
