Feature: API Validation
  In order to prevent the processing of invalid data
  As a consuming service
  I want to ensure all JSON payload(request) parameters are validated

   @test
  Scenario Outline: API Validation 01: CountyCode is missing in the request
    Given that I send a request to document API
    When the <field name> is missing
    Then the response code is "400"

    Examples:
    |field name|
    |country code|
    |folder Id|

  @test
  Scenario: API Validation 02: Document API returns a success response
    Given that I send a request to document API
    When all the mandatory fields are present in the request
    Then the response code equals "200"
    Then the response text is "Saved"

  @test
  Scenario: API Validation 03: Document API returns a bad request response
    Given that I send a request to document API
    When the header is missing
    |countryCode|
    Then the response code is "400"