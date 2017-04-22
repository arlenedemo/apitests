package com.demo.digital.testautomation.restassured;

import com.demo.digital.testautomation.request.Headers;
import com.demo.digital.testautomation.request.HeadersBuilder;
import com.demo.digital.testautomation.test.UploadDocumentType;
import com.demo.digital.testautomation.util.FileReader;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;

import java.io.File;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

/**
 * Created by arlene.lehakra on 16/01/2017.
 */
public class RestAssuredCore {

    public static Headers getHeader() throws Exception{
        return new HeadersBuilder().build();
    }

    public static ExtractableResponse postAsMultipartAndReturnResponse(final String postDestination, final String jsonBody, final UploadDocumentType docType, final int status) {

        return postAsMultipartAndReturnResponse(postDestination, jsonBody, FileReader.getAttachmentPath(docType), status);
    }

    public static Response fetchGetResponse(final String postDestination, final String jsonBody, final int status){

        java.util.Map<String, String> mappedValues = null;
        try {
            mappedValues = getHeader().getMappedHeaderValues();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return given().headers(mappedValues).contentType("application/json").when().get(postDestination).then()
                .assertThat().statusCode(is(status)).extract().response();
    }

    public static void printResponse(final ExtractableResponse response){
        response.response().getBody().prettyPrint();
    }

    public static ExtractableResponse postAsMultipartAndReturnResponse(final String postDestination, final String jsonBody, final String attachmentPath, final int status) {
        java.util.Map<String, String> mappedValues = null;

        try {
            mappedValues = getHeader().getMappedHeaderValues();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return given().headers(mappedValues).contentType("multipart/form-data").multiPart(new File(attachmentPath)).param("JsonParameters", jsonBody).when().post(postDestination).then()
                .assertThat().statusCode(is(status)).extract();
    }

}
