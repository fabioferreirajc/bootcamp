package org.academiadecodigo.bootcamp.utils;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;

public class MimeHelper {

    private MimetypesFileTypeMap map = new MimetypesFileTypeMap();

    public MimeHelper() {
        map.addMimeTypes("image/png png");
        map.addMimeTypes("image/ico ico");
    }

    public String getMimeType(File file) {
        return map.getContentType(file);
    }

}
