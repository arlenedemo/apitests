package com.demo.digital.testautomation.stepdefs;

import com.demo.digital.testautomation.actions.RequestValidation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by arlene.lehakra on 10/04/2017.
 */
public class ApiValidationTest {

    RequestValidation requestValidation = new RequestValidation();

    @Given("^that I send a request to document upload API$")
    public void that_I_send_a_request_to_document_upload_API() throws Throwable {

    }

    @When("^the country code is missing$")
    public void the_country_code_is_missing() throws Throwable {
        requestValidation.countryCodeMissing();
    }

    @Then("^the response code is \"([^\"]*)\"$")
    public void the_response_code_is(String arg1) throws Throwable {
        requestValidation.verifyResponseCode(400);
    }

    @When("^the folder Id length is less than (\\d+) characters$")
    public void the_folder_Id_less_than_characters(int arg1) throws Throwable {
        requestValidation.folderIdLessThan10Char();
    }

}
