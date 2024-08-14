package com.lbg.utils.testservice.stepdefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;


public class BatchStepDefinitions {

    private Response response;
    private String baseUrl = "http://localhost:8081/api/books";

    @Given("a book exists with an id of {int}")
    public void a_book_exists_with_an_id_of(Integer id) {
        RestAssured.given()
                .contentType("application/json")
                .body("{\"id\":" + id + ", \"title\": \"Sample Book\", \"author\": \"Author Name\"}")
                .post(baseUrl)
                .then()
                .statusCode(201);
    }

    @When("I retrieve the book with id {int}")
    public void i_retrieve_the_book_with_id(Integer id) {
        response = RestAssured.get(baseUrl + "/" + id);
    }

    @Then("the book title should be {string}")
    public void the_book_title_should_be(String title) {
        response.then().statusCode(200).body("title", equalTo(title));
    }

    @When("I update the book with id {int} to have the title {string}")
    public void i_update_the_book_with_id_to_have_the_title(Integer id, String title) {
        RestAssured.given()
                .contentType("application/json")
                .body("{\"title\": \"" + title + "\", \"author\": \"Updated Author\"}")
                .put(baseUrl + "/" + id)
                .then()
                .statusCode(200);
    }

    @When("I delete the book with id {int}")
    public void i_delete_the_book_with_id(Integer id) {
        RestAssured.delete(baseUrl + "/" + id)
                .then()
                .statusCode(204);
    }

    @Then("the book should not exist with id {int}")
    public void the_book_should_not_exist_with_id(Integer id) {
        RestAssured.get(baseUrl + "/" + id)
                .then()
                .statusCode(404);
    }
}


