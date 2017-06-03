package com.demo.digital.testautomation.actions;

import com.google.gson.Gson;
import com.demo.digital.testautomation.config.ConfigProvider;
import com.demo.digital.testautomation.restassured.RestAssuredCore;
import com.jayway.restassured.response.ExtractableResponse;
import com.typesafe.config.Config;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertTrue;

/**
 * Created by arlene.lehakra on 16/01/2017.
 */
public class RequestValidation {

    private Config config;

    private ExtractableResponse response;

    @Before
    public void setUp() throws Exception{
        this.config= ConfigProvider.config();
        //RestAssured.baseURI= this.config.getString("BaseApiUri");
    }


    private static Request getFullRequest(){
        Request allDataPresent = new Request();
        DocumentProperties documentData = new DocumentProperties();
        documentData.documentFormat="pdf";
        documentData.fileName="test.pdf";
        documentData.countryCode="UK";
        documentData.folderId="1234567890";
        allDataPresent.documentData = documentData;
        return allDataPresent;
    }

    public void fileNameMissing(){
        Request allDataPresent = getFullRequest();
        allDataPresent.documentData.fileName=null;

        Gson gson= new Gson();
        String jsonBody = gson.toJson(allDataPresent);
        System.out.println(jsonBody);


        response = RestAssuredCore.postAsMultipartAndReturnResponse((this.config.getString("iccmBaseApiUri")),jsonBody,UploadDocumentType.PDF_SMALL, HttpStatus.SC_BAD_REQUEST);
    }

    public void countryCodeMissing(){
        Request allDataPresent = getFullRequest();
        allDataPresent.documentData.countryCode=null;

        Gson gson= new Gson();
        String jsonBody = gson.toJson(allDataPresent);
        System.out.println(jsonBody);


        response=RestAssuredCore.postAsMultipartAndReturnResponse("http://localhost:8081/tutorial1/action3",jsonBody,UploadDocumentType.JPEG_SMALL, HttpStatus.SC_BAD_REQUEST);

        RestAssuredCore.printResponse(response);

    }

    public void validRequest(){
        Request allDataPresent = getFullRequest();

        Gson gson= new Gson();
        String jsonBody = gson.toJson(allDataPresent);
        System.out.println(jsonBody);


        response=RestAssuredCore.postAsMultipartAndReturnResponse("http://localhost:8081/tutorial1/action2",jsonBody,UploadDocumentType.JPEG_SMALL, HttpStatus.SC_OK);

        RestAssuredCore.printResponse(response);

    }

    public void folderIdMissing() {
        Request allDataPresent = getFullRequest();
        allDataPresent.documentData.folderId = null;

        Gson gson = new Gson();
        String jsonBody = gson.toJson(allDataPresent);
        System.out.println(jsonBody);


        response = RestAssuredCore.postAsMultipartAndReturnResponse("http://localhost:8081/tutorial1/action3", jsonBody, UploadDocumentType.JPEG_SMALL, HttpStatus.SC_BAD_REQUEST);

        RestAssuredCore.printResponse(response);
    }

    public void verifyErrorResponseCode(int expectedErrorCode){
        int expectedCode = 400;
        String expectedMessage= "Bad Request";

        int actualCode = response.statusCode();
        String jsonAsString = response.asString();

        Assert.assertEquals(expectedCode, actualCode);
        Assert.assertEquals(expectedMessage, jsonAsString);
    }

    public void verifySuccessResponseCode(int expectedCode){
        int expected = 200;
        int actual = response.statusCode();

        Assert.assertEquals(expected, actual);
    }

    public void folderIdLessThan10Char(){
        Request allDataPresent = getFullRequest();
        allDataPresent.documentData.folderId="123456";

        Gson gson= new Gson();
        String jsonBody = gson.toJson(allDataPresent);
        System.out.println(jsonBody);


        response = RestAssuredCore.postAsMultipartAndReturnResponse("http://localhost:8081/tutorial1/action3",jsonBody,UploadDocumentType.JPEG_SMALL, HttpStatus.SC_BAD_REQUEST);
    }

}
