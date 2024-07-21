package ui.stepdef;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import ui.stepdef.BaseTest;

public class CucumberHooks extends BaseTest {

    @Before(order = 1)
    public void beforeTest() {
        getDriver();
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
