package ui.stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SampleStepDef {
    @When("Sample Test Run")
    public void sampleTestRun() {
        Assertions.assertEquals(1,1);
    }

    @Then("Test Succeed")
    public void testSucceed() {
        Assertions.assertEquals(1,1);
    }
}
