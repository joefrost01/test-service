package com.lbg.utils.testservice.stepdefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

import static org.hamcrest.Matchers.equalTo;

@Slf4j
public class BatchStepDefinitions {

    private LocalDate batchDate;
    private String batchServiceUrl;

    @Given("the batch date is set to the provided date")
    public void set_batch_date() {
        String date = System.getProperty("batchDate");
        this.batchDate = LocalDate.parse(date);
        this.batchServiceUrl = System.getProperty("batchServiceUrl");
    }

    @When("I execute the batch for that date")
    public void execute_batch_for_date() {
        log.info("Executing batch for date: {}", batchDate);
        RestAssured.given().contentType("application/json").param("date", batchDate)
                .when().post(batchServiceUrl+"/api/v1/runBatch")
                .then().statusCode(201);
    }

    @Then("the batch should execute {int} jobs successfully")
    public void verify_batch_completion() {
        // Verification logic here
    }

}


