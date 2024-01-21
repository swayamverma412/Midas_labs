Feature: Greeting API

  Scenario: Greeting with default name
    Given the application is running
    When a user requests the greeting endpoint
    Then the response should contain the default greeting message

  Scenario: Greeting with a custom name
    Given the application is running
    When a user requests the greeting endpoint with name "Spring Community"
    Then the response should contain the tailored greeting message
