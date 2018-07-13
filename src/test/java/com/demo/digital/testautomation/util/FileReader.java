package com.demo.digital.testautomation.util;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileReader {

    public String readFile(String fileName) throws IOException{
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream in = classLoader.getResourceAsStream(fileName);
        String content = IOUtils.toString(in);
        return content;
    }

}
