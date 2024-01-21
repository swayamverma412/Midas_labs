package com.example.restservice;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

public class GreetingStepDefinitions {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<Greeting> responseEntity;

    @Given("the application is running")
    public void theApplicationIsRunning() {
        // Nothing to do here; assume the application is already running
    }

    @When("a user requests the greeting endpoint")
    public void aUserRequestsTheGreetingEndpoint() {
        responseEntity = restTemplate.getForEntity("/greeting", Greeting.class);
    }

    @When("a user requests the greeting endpoint with name {string}")
    public void aUserRequestsTheGreetingEndpointWithName(String name) {
        responseEntity = restTemplate.getForEntity("/greeting?name=" + name, Greeting.class);
    }

   @Then("the response should contain the default greeting message")
    public void theResponseShouldContainTheDefaultGreetingMessage() {
        if (responseEntity != null && responseEntity.getBody() != null) {
            assertEquals("Hello, World!", responseEntity.getBody().getContent());
        } else {
            fail("Response entity or response body is null");
        }
    }

    @Then("the response should contain the tailored greeting message")
    public void theResponseShouldContainTheTailoredGreetingMessage() {
        if (responseEntity != null && responseEntity.getBody() != null) {
            assertEquals("Hello, Spring Community!", responseEntity.getBody().getContent());
        } else {
            fail("Response entity or response body is null");
        }
    }

}
