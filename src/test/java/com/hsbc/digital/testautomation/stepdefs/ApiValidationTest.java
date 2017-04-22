package com.hsbc.digital.testautomation.stepdefs;

import com.hsbc.digital.testautomation.test.RequestValidation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by arlene.lehakra on 10/04/2017.
 */
public class ApiValidationTest {

    RequestValidation requestValidation = new RequestValidation();

    @Given("^that I send a request to document upload API with missing country code$")
    public void that_I_send_a_request_to_document_upload_API_with_missing_country_code() throws Throwable {
        requestValidation.countryCodeMissing();
    }

    @Then("^the response code is \"([^\"]*)\"$")
    public void the_response_code_is(String arg1) throws Throwable {
        requestValidation.verifyResponseCode(400);
    }

    @Given("^that I send a request to document upload API with folder Id less than (\\d+) characters$")
    public void that_I_send_a_request_to_document_upload_API_with_folder_Id_less_than_characters(int arg1) throws Throwable {
        requestValidation.folderIdLessThan10Char();
    }

}
