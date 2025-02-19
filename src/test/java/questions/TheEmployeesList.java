package questions;

import net.serenitybdd.rest. SerenityRest;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class TheEmployeesList {
    public static Question<List<Object>> inTheResponse() {
        return actor -> SerenityRest.lastResponse().jsonPath().getList("data");
    }
}