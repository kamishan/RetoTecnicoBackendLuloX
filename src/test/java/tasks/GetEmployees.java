package tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetEmployees implements Task {

    @Override
    @Step("{0} attempts to retrieve all employees from the API")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/employees")
        );
    }

    public static GetEmployees fromApi() {
        return instrumented(GetEmployees.class);
    }
}