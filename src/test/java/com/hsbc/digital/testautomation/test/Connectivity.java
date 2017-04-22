package com.hsbc.digital.testautomation.test;

import com.google.gson.Gson;
import com.hsbc.digital.testautomation.config.ConfigProvider;
import com.hsbc.digital.testautomation.restassured.RestAssuredCore;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ExtractableResponse;
import com.typesafe.config.Config;
import org.apache.http.HttpStatus;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * Created by arlene.lehakra on 16/01/2017.
 */
public class Connectivity {

    private Config config;
    private ExtractableResponse response;
    @Before
    public void setUp() throws Exception{
        this.config= ConfigProvider.config();
        RestAssured.baseURI= this.config.getString("iccmBaseApiUri");
    }

    private static Request getFullRequest(){
        Request allDataPresent = new Request();
        DocumentProperties documentData = new DocumentProperties();
        documentData.documentFormat="pdf";
        documentData.fileName="test.pdf";
        documentData.countryCode="UK";
        documentData.grpMbrCode="HBEU";
        documentData.folderId="1234567890";
        documentData.folderType="000020";
        allDataPresent.documentData = documentData;
        return allDataPresent;
    }

    public void fileUploadSuccess(){
        Request allDataPresent = getFullRequest();
        String expectedStatus= "SAVED";

        Gson gson= new Gson();
        String jsonBody = gson.toJson(allDataPresent);
        System.out.println(jsonBody);


        response = RestAssuredCore.postAsMultipartAndReturnResponse((this.config.getString("iccmBaseApiUri")),jsonBody,UploadDocumentType.JPEG_SMALL, HttpStatus.SC_OK);

        RestAssuredCore.printResponse(response);

        assertEquals(expectedStatus, response.path("status"));



    }


}

