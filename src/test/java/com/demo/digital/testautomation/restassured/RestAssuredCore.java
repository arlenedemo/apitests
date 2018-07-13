package com.demo.digital.testautomation.restassured;

import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

/**
 * Created by arlene.lehakra on 16/01/2017.
 */
public class RestAssuredCore {


    public static Response fetchResponse(){

        return given().contentType("application/json").when().get("https://api.romil.co/prod/authorize").then()
                .assertThat().statusCode(is(200)).extract().response();
    }

    public static void printResponse(final ExtractableResponse response){
        response.response().getBody().prettyPrint();
    }


}
