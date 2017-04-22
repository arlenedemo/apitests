package com.hsbc.digital.testautomation.test;

import com.google.gson.Gson;
import com.hsbc.digital.testautomation.config.ConfigProvider;
import com.hsbc.digital.testautomation.mongo.MongoAgent;
import com.hsbc.digital.testautomation.mongo.MongoAgentCollectionQuery;
import com.hsbc.digital.testautomation.restassured.RestAssuredCore;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ExtractableResponse;
import com.mongodb.client.FindIterable;
import com.typesafe.config.Config;
import org.apache.http.HttpStatus;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Before;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by arlene.lehakra on 23/01/2017.
 */
public class CallBackTestFlow {

    private Config config;
    private ExtractableResponse response;

    @Before
    public void setUp() throws Exception {
        this.config = ConfigProvider.config();
        RestAssured.baseURI = this.config.getString("iccmBaseApiUri");
    }

    private static Request getFullRequest() {
        Request allDataPresent = new Request();
        DocumentProperties documentData = new DocumentProperties();
        documentData.documentFormat = "pdf";
        documentData.fileName = "test.pdf";
        documentData.countryCode = "UK";
        documentData.grpMbrCode = "HBEU";
        documentData.folderId = "1234567890";
        documentData.folderType = "000020";
        allDataPresent.documentData = documentData;
        return allDataPresent;
    }

    public void docSavedOnFileNet() throws Exception {
        Request allDataPresent = getFullRequest();

        String expectedStatus = "SAVED";

        boolean foundResult =false;
        Gson gson = new Gson();
        String jsonBody = gson.toJson(allDataPresent);
        System.out.println(jsonBody);


        response = RestAssuredCore.postAsMultipartAndReturnResponse((this.config.getString("iccmBaseApiUri")), jsonBody, UploadDocumentType.PDF_SMALL, HttpStatus.SC_OK);

        RestAssuredCore.printResponse(response);

        String actualStatus = response.path("status");

        assertEquals(expectedStatus, actualStatus);

        String tempDocId = response.path("addDocReponse.tempDocumentRequestId");

        Bson query = and(eq("documentCallbackData.tempDocumentRequestId", tempDocId), eq("documentCallbackData.status", "SAVED"));


            try (MongoAgent agent = new MongoAgent("130.49.108.140", 5255, "DigitalUtilities")) {

                foundResult=MongoAgentCollectionQuery.findDocumentInCollectionUsingQuery(agent,query);
            }

            assertTrue(foundResult);
    }


    public void saveRequestFailed() throws Exception {
        Request allDataPresent = getFullRequest();

        String expectedStatus = "ICCM_PROCESSING_ERROR";

        boolean foundResult= false;
        Gson gson = new Gson();
        String jsonBody = gson.toJson(allDataPresent);
        System.out.println(jsonBody);


        response = RestAssuredCore.postAsMultipartAndReturnResponse((this.config.getString("iccmBaseApiUri")), jsonBody, UploadDocumentType.JPEG_SMALL, HttpStatus.SC_OK);

        RestAssuredCore.printResponse(response);

        String actualStatus = response.path("status");

        assertEquals(expectedStatus, actualStatus);

        String tempDocId = response.path("addDocReponse.tempDocumentRequestId");

        Bson query = and(eq("documentCallbackData.tempDocumentRequestId", tempDocId), eq("documentCallbackData.status", "ICCM_PROCESSING_ERROR"));


        try (MongoAgent agent = new MongoAgent("130.49.108.140", 5255, "DigitalUtilities")) {

            foundResult=MongoAgentCollectionQuery.findDocumentInCollectionUsingQuery(agent,query);
    }

        assertTrue(foundResult);
    }
}