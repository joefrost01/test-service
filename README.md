# Test Service Project

This project is a Spring Boot application that orchestrates and runs Cucumber tests. It includes a web interface to trigger tests and view the results.

## Project Structure

- `src/main/java/com/lbg/utils/testservice/component/BatchTriggerTestInvoker.java`: Component responsible for invoking Cucumber tests and generating JSON reports.
- `src/main/resources/features/batch_triggering/batch_triggering.feature`: Cucumber feature file containing test scenarios.
- `src/main/java/com/lbg/utils/testservice/stepdefs/BatchStepDefinitions`: Step definitions for the Cucumber tests - uses RESTAssured to make HTTP requests.
- `src/main/java/com/lbg/utils/testservice/controller/ui/TestOrchestratorController.java`: Controller that handles HTTP requests to run tests and display the results.
- `src/main/resources/templates/report.html`: Thymeleaf template for displaying the Cucumber test report.

## Prerequisites

- Java 8 or higher
- Maven 3.6.3 or higher

## Getting Started

1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourusername/test-service.git
    cd test-service
    ```

2. **Build the project:**
    ```sh
    mvn clean install
    ```

3. **Run the application:**
    ```sh
    mvn spring-boot:run
    ```

4. **Access the web interface:**
    Open your browser and navigate to `http://localhost:8080/run-tests` to trigger the tests and view the report.

## Running Tests

The tests are defined in the `batch_triggering.feature` file. You can run the tests by accessing the `/run-tests` 
endpoint. The results will be displayed in a formatted report.

Note that this service uses test frameworks to execute tests against other services so all the code is in the main 
folder rather than the test folder where you would normally expect to find it.

New tests can be added by cloning the BatchTriggerTestInvoker, and BatchStepDefinitions classes and creating new 
feature files.

The TestOrchestrator service can be used to combine different invokers and run integration tests in series across 
different services.

## Project Dependencies

- Spring Boot
- Cucumber
- Jackson
- Thymeleaf
- Lombok

## Further Reading

- [Cucumber Documentation](https://cucumber.io/docs/cucumber/)
- [RESTAssured Documentation](https://rest-assured.io/)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)


