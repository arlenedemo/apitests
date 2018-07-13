package com.demo.digital.testautomation.stepdefs;

import com.demo.digital.testautomation.actions.RequestValidation;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

/**
 * Created by arlene.lehakra on 10/04/2017.
 */
public class ApiValidationTest {

    RequestValidation requestValidation = new RequestValidation();

    @Given("^that I send a valid request to authorise API$")
    public void that_I_send_a_valid_request_to_authorise_API() throws Throwable {

    }


    @Then("^the response code is '(\\d+)'$")
    public void the_response_is_200(String arg1) throws Throwable {
        requestValidation.verifyUsername("200");
    }

}
