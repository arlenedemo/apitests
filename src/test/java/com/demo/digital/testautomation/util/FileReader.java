package com.demo.digital.testautomation.util;
import com.demo.digital.testautomation.actions.UploadDocumentType;
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
    public  String getResourcePath(final UploadDocumentType docType){

        String filepath="";
        ClassLoader classLoader = this.getClass().getClassLoader();
        switch (docType){
            case PDF_SMALL:
                filepath="documents_to_attach/test.pdf";
                break;
            case PDF_BOUNDARY:
                filepath="documents_to_attach/test.pdf";
                break;
            case PDF_LARGE:
                filepath="documents_to_attach/test.pdf";
                break;
            case JPEG_SMALL:
                filepath="documents_to_attach/jpegimage.jpg";
                break;
            case BMP_SMALL:
                filepath="documents_to_attach/bmpimage.bmp";
                break;
            case GIF_SMALL:
                filepath="documents_to_attach/gifimage.gif";
                break;
            case PNG_SMALL:
                filepath="documents_to_attach/agile.png";
                break;
            case DOC_SMALL:
                filepath="documents_to_attach/test.pdf";
                break;
            case NO_FILE:
                filepath=null;
                break;
            default:
                filepath="documents_to_attach/test.pdf";
                break;

        }
        File file = new File(classLoader.getResource(filepath).getFile());

        return file.getAbsolutePath();
    }

    public static String getAttachmentPath(final UploadDocumentType docType){

        String filepath="";
        switch (docType){
            case PDF_SMALL:
                filepath="..\\apitests\\src\\test\\resources\\documents_to_attach\\test.pdf";
                break;
            case PDF_BOUNDARY:
                filepath="..\\apitests\\src\\test\\resources\\documents_to_attach\\test.pdf";
                break;
            case PDF_LARGE:
                filepath="..\\apitests\\src\\test\\resources\\documents_to_attach\\test.pdf";
                break;
            case JPEG_SMALL:
                filepath="..\\apitests\\src\\test\\resources\\documents_to_attach\\jpegimage.jpg";
                break;
            case BMP_SMALL:
                filepath="..\\apitests\\src\\test\\resources\\documents_to_attach\\bmpimage.bmp";
                break;
            case GIF_SMALL:
                filepath="..\\apitests\\src\\test\\resources\\documents_to_attach\\gifimage.gif";
                break;
            case PNG_SMALL:
                filepath="..\\apitests\\src\\test\\resources\\documents_to_attach\\agile.png";
                break;
            case DOC_SMALL:
                filepath="..\\apitests\\src\\test\\resources\\documents_to_attach\\test.pdf";
                break;
            case NO_FILE:
                filepath=null;
                break;
            default:
                filepath="..\\apitests\\src\\test\\resources\\documents_to_attach\\test.pdf";
                break;

        }
        return filepath;
    }
}
