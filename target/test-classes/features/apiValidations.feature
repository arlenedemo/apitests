Feature: API Validation
  In order to prevent the processing of invalid data
  As a consuming service
  I want to ensure all JSON payload(request) parameters are validated

  @test
  Scenario: API Validation 01: CountyCode is missing in the request
    Given that I send a request to document upload API with missing country code
    Then the response code is "400"

  @test
  Scenario: API Validation 02: Folder Id is less than 10 characters
    Given that I send a request to document upload API with folder Id less than 10 characters
    Then the response code is "400"

