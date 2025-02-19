package questions;

import net.serenitybdd.rest. SerenityRest;
import net.serenitybdd.screenplay.Question;

public class EmployeeData {
    public static Question<String> forKey(String key) {
        return actor -> SerenityRest.lastResponse().jsonPath().getString("data." + key);
    }
}