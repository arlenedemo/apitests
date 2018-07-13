Feature: API Validation

  @test
  Scenario: API Validation 01: API returns a success response
    Given that I send a valid request to authorise API
    Then the response code is '200'
