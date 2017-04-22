package com.hsbc.digital.testautomation.util;
import com.hsbc.digital.testautomation.test.UploadDocumentType;
import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.IOException;
import java.io.InputStream;

public class FileReader {

    public String readFile(String fileName) throws IOException{
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream in = classLoader.getResourceAsStream(fileName);
        String content = IOUtils.toString(in);
        return content;
    }

    public static String getAttachmentPath(final UploadDocumentType docType){

        String filepath="";
        switch (docType){
            case PDF_SMALL:
                filepath="..\\document_upload_integration_tests\\src\\test\\resources\\documents_to_attach\\test.pdf";
                break;
            case PDF_BOUNDARY:
                filepath="..\\document_upload_integration_tests\\src\\test\\resources\\documents_to_attach\\test.pdf";
                break;
            case PDF_LARGE:
                filepath="..\\document_upload_integration_tests\\src\\test\\resources\\documents_to_attach\\test.pdf";
                break;
            case JPEG_SMALL:
                filepath="..\\document_upload_integration_tests\\src\\test\\resources\\documents_to_attach\\jpegimage.jpg";
                break;
            case BMP_SMALL:
                filepath="..\\document_upload_integration_tests\\src\\test\\resources\\documents_to_attach\\bmpimage.bmp";
                break;
            case GIF_SMALL:
                filepath="..\\document_upload_integration_tests\\src\\test\\resources\\documents_to_attach\\gifimage.gif";
                break;
            case PNG_SMALL:
                filepath="..\\document_upload_integration_tests\\src\\test\\resources\\documents_to_attach\\agile.png";
                break;
            case DOC_SMALL:
                filepath="..\\document_upload_integration_tests\\src\\test\\resources\\documents_to_attach\\test.pdf";
                break;
            case NO_FILE:
                filepath=null;
                break;
            default:
                filepath="..\\document_upload_integration_tests\\src\\test\\resources\\documents_to_attach\\test.pdf";
                break;

        }
        return filepath;
    }
}
