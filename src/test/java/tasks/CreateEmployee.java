package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateEmployee implements Task {

    private final String name;
    private final String salary;
    private final String age;

    public CreateEmployee(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    @Step("{0} attempts to create a new employee with name #name, salary #salary, and age #age")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/create").with(
                        request -> request.header("Content-Type", "application/json")
                                .body(String.format("{\n" +
                                        "  \"name\": \"%s\",\n" +
                                        "  \"salary\": \"%s\",\n" +
                                        "  \"age\": \"%s\"\n" +
                                        "}", name, salary, age))
                )
        );
    }

    public static CreateEmployee withDetails(String name, String salary, String age) {
        return instrumented(CreateEmployee.class, name, salary, age);
    }
}