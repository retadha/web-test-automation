package api.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;

public class MyStepdefs {
    @Given("check first time")
    public void checkFirstTime() {
    Assertions.assertEquals(1,1);
    }

    @And("test succeed")
    public void testSucceed() {
    }
}
