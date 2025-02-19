package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import questions.*;
import tasks.CreateEmployee;
import tasks.DeleteEmployee;
import tasks.GetEmployee;
import tasks.GetEmployees;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class EmployeeStepDefinitions {
    private Actor actor;
    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage() {
        environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        String baseUrl = environmentVariables.getProperty("restapi.baseurl");
        actor = Actor.named("API Tester")
                .whoCan(CallAnApi.at(baseUrl));
    }

    @Given("I send a GET request to retrieve all employees")
    public void iSendAGETRequestToRetrieveAllEmployees() {
        actor.attemptsTo(GetEmployees.fromApi());
    }

    @Given("I send a POST request to create a new employee with name {string}, salary {string}, and age {string}")
    public void iSendAPOSTRequestToCreateANewEmployee(String name, String salary, String age) {
        actor.attemptsTo(CreateEmployee.withDetails(name, salary, age));
    }

    @Given("I send a GET request to retrieve employee with id {string}")
    public void iSendAGETRequestToRetrieveEmployeeWithId(String id) {
        actor.attemptsTo(GetEmployee.withId(id));
    }

    @Given("I send a DELETE request to delete employee with id {string}")
    public void iSendADELETERequestToDeleteEmployeeWithId(String id) {
        actor.attemptsTo(DeleteEmployee.withId(id));
    }

    @When("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        actor.should(seeThat(ResponseStatusCode.is(), equalTo(statusCode)));
    }

    @Then("the response should contain a non-empty list of employees")
    public void theResponseShouldContainANonEmptyListOfEmployees() {
        actor.should(seeThat(TheEmployeesList.inTheResponse(), hasSize(greaterThan(0))));
    }

    @Then("the response body should contain the created employee details")
    public void theResponseBodyShouldContainTheCreatedEmployeeDetails() {
        actor.should(
                seeThat(TheResponseStatus.is(), equalTo("success")),
                seeThat(EmployeeData.forKey("name"), equalTo("John Doe")),
                seeThat(EmployeeData.forKey("salary"), equalTo("50000")),
                seeThat(EmployeeData.forKey("age"), equalTo("30"))
        );
    }

    @Then("the response body should contain the employee details for id {string}")
    public void theResponseBodyShouldContainTheEmployeeDetailsForId(String id) {
        actor.should(
                seeThat(TheResponseStatus.is(), equalTo("success")),
                seeThat(EmployeeData.forKey("id"), equalTo(id))
        );
    }

    @Then("the response should indicate successful deletion")
    public void theResponseShouldIndicateSuccessfulDeletion() {
        actor.should(
                seeThat(DeletionMessage.is(), equalTo("successfully! deleted Records"))
        );
    }
}