package com.demo.digital.testautomation.actions;

import com.google.gson.Gson;
import com.demo.digital.testautomation.config.ConfigProvider;
import com.demo.digital.testautomation.restassured.RestAssuredCore;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;
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

    private Response response;

    @Before
    public void setUp() throws Exception{
        this.config= ConfigProvider.config();
    }

    public void verifyUsername(String status){

        response = RestAssuredCore.fetchResponse();
        System.out.println("\n");
        response.prettyPrint();
    }

}
