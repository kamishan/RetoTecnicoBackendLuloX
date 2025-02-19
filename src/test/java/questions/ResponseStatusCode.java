package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class ResponseStatusCode {
    public static Question<Integer> is() {
        return actor -> SerenityRest.lastResponse().statusCode();
    }
}