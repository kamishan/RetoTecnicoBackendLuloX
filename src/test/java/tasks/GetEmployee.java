package tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetEmployee implements Task {

    private final String id;

    public GetEmployee(String id) {
        this.id = id;
    }

    @Override
    @Step("{0} attempts to retrieve employee with id #id")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/employee/{id}").with(
                        request -> request.pathParam("id", id)
                )
        );
    }

    public static GetEmployee withId(String id) {
        return instrumented(GetEmployee.class, id);
    }
}