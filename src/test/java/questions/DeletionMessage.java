package questions;

import net.serenitybdd.rest. SerenityRest;
import net.serenitybdd.screenplay.Question;

public class DeletionMessage {
    public static Question<String> is() {
        return actor -> SerenityRest.lastResponse().jsonPath().getString("message");
    }
}