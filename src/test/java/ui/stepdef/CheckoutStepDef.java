package ui.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.pages.CartPage;
import ui.pages.CheckoutPage;
import ui.pages.InventoryPage;
import ui.pages.LoginPage;
import ui.stepdef.BaseTest;

public class CheckoutStepDef extends BaseTest {

    protected LoginPage loginPage = new LoginPage(driver);
    protected InventoryPage inventoryPage = new InventoryPage(driver);
    protected CartPage cartPage = new CartPage(driver);
    protected CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Given("user is on cart page")
    public void userIsOnCartPage() {
        loginPage.goToLoginPage();
        loginPage.login();
        cartPage.goToCartPage();
    }

    @And("cart is empty")
    public void cartIsEmpty() {
        cartPage.validateEmptyCart();
    }

    @When("user checkout")
    public void userCheckout() {
        cartPage.checkout();
    }

    @Then("checkout error message {string} shows up")
    public void checkoutErrorMessageShowsUp(String errorMessage) {
        checkoutPage.validateErrorMessageDisplayed(errorMessage);

    }


    @And("user input first name on checkout form with {string}")
    public void userInputFirstNameOnCheckoutFormWith(String firstName) {
        checkoutPage.inputFirstName(firstName);
    }

    @And("user input postal code on checkout form with {string}")
    public void userInputPostalCodeOnCheckoutFormWith(String postalCode) {
        checkoutPage.inputPostalCode(postalCode);
    }

    @And("user click continue checkout")
    public void userClickContinueCheckout() {
        checkoutPage.continueCheckout();
    }

    @And("user input last name on checkout form with {string}")
    public void userInputLastNameOnCheckoutFormWith(String name) {
        checkoutPage.inputLastName(name);
    }

    @And("user see checkout detail")
    public void userSeeCheckoutDetail() {
        checkoutPage.validateDetailsDisplayed();
    }

    @And("checkout detail has {int} items")
    public void checkoutDetailHasItems(int n) {
        checkoutPage.validateItemNumber(n);
    }

    @When("user click finish checkout")
    public void userClickFinishCheckout() {
        checkoutPage.finishCheckout();
    }

    @Then("user see checkout complete message {string}")
    public void userSeeCheckoutCompleteMessage(String message) {
        checkoutPage.validateCheckoutCompleteMessageDisplayed(message);
    }
}
