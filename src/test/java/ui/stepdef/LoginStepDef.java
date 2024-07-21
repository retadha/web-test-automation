package ui.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.pages.InventoryPage;
import ui.pages.LoginPage;
import ui.stepdef.BaseTest;

public class LoginStepDef extends BaseTest {

    protected LoginPage loginPage = new LoginPage(driver);
    protected InventoryPage inventoryPage = new InventoryPage(driver);

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage.goToLoginPage();
    }

    @When("user input username on username field with {string}")
    public void userInputUsernameOnUsernameFieldWith(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input password on password field with {string}")
    public void userInputPasswordOnPasswordFieldWith(String password) {
        loginPage.inputPassword(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();

    }

    @Then("user redirect to inventory page")
    public void userRedirectToInventoryPage() {

        inventoryPage.validateInInventoryPage();
    }

    @Then("error message {string} shows up")
    public void errorMessageShowsUp(String errorMessage) {
        loginPage.validateErrorMessageDisplayed("Epic sadface: Password is required");
    }


}
