package questions;

import net.serenitybdd.rest. SerenityRest;
import net.serenitybdd.screenplay.Question;

public class TheResponseStatus {
    public static Question<String> is() {
        return actor -> SerenityRest.lastResponse().jsonPath().getString("status");
    }
}