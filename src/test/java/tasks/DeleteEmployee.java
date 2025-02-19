package tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteEmployee implements Task {

    private final String id;

    public DeleteEmployee(String id) {
        this.id = id;
    }

    @Override
    @Step("{0} attempts to delete employee with id #id")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/delete/{id}").with(
                        request -> request.pathParam("id", id)
                )
        );
    }

    public static DeleteEmployee withId(String id) {
        return instrumented(DeleteEmployee.class, id);
    }
}