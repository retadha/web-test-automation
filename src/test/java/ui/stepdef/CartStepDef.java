package ui.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.pages.CartPage;
import ui.pages.InventoryPage;
import ui.pages.LoginPage;
import ui.stepdef.BaseTest;

public class CartStepDef extends BaseTest {

    protected LoginPage loginPage = new LoginPage(driver);
    protected InventoryPage inventoryPage = new InventoryPage(driver);
    protected CartPage cartPage = new CartPage(driver);

    @When("user add {string} to cart")
    public void userAddToCart(String product) {
        inventoryPage.goToInventoryPage();
        inventoryPage.addtoCart(product);
    }

    @And("cart page has {int} items")
    public void cartPageHasItems(int n) {
        cartPage.goToCartPage();
        cartPage.validateItemNumber(n);
    }

    @Then("cart badge shown as {int}")
    public void cartBadgeShownAs(int n) {
        cartPage.validateCartBadgeDisplayed();
        cartPage.validateBadgeNumber(n);
    }

    @And("user remove {string} from cart")
    public void userRemoveFromCart(String product) {
        cartPage.goToCartPage();
        cartPage.removeFromCart(product);
    }
}
