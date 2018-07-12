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

    @Given("^that I send a request to document API$")
    public void that_I_send_a_request_to_document_upload_API() throws Throwable {

    }

    @When("^the country code is missing$")
    public void the_country_code_is_missing() throws Throwable {
        requestValidation.countryCodeMissing();
    }

    @When("^the folder Id is missing$")
    public void the_folder_Id_is_missing() throws Throwable {
        requestValidation.folderIdMissing();
    }

    @Then("^the response code is \"([^\"]*)\"$")
    public void the_response_code_is(String arg1) throws Throwable {
        requestValidation.verifyErrorResponseCode(400);
    }


    @When("^the header is missing$")
    public void the_header_is_missing(List<String> headerName) throws Throwable {
        requestValidation.headerMissing(headerName.get(0));
    }

    @When("^all the mandatory fields are present in the request$")
    public void all_the_mandatory_fields_are_present_in_the_request() throws Throwable {
        requestValidation.validRequest();
    }

    @When("^the folder Id length is less than (\\d+) characters$")
    public void the_folder_Id_less_than_characters(int arg1) throws Throwable {
        requestValidation.folderIdLessThan10Char();
    }

    @Then("^the response code equals \"([^\"]*)\"$")
    public void the_response_code_equals(String arg1) throws Throwable {
        requestValidation.verifySuccessResponseCode(200);
    }

    @Then("^the response text is \"([^\"]*)\"$")
    public void the_response_text_is(String arg1) throws Throwable {
        requestValidation.verifyResponseText("Saved");
    }


}
