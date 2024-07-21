package ui.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.pages.InventoryPage;
import ui.pages.LoginPage;
import ui.stepdef.BaseTest;

public class InventoryStepDef extends BaseTest {
    protected LoginPage loginPage = new LoginPage(driver);
    protected InventoryPage inventoryPage = new InventoryPage(driver);

    @And("user is on inventory page")
    public void userIsOnInventoryPage() {
        loginPage.goToLoginPage();
        loginPage.login();
        inventoryPage.validateInInventoryPage();
    }

    @Then("user see item list")
    public void userSeeItemList() {
        inventoryPage.validateProductsDisplayed();
    }

    @And("items are sorted by names in ascending order")
    public void itemsAreSortedByNamesInAscendingOrder() {
        inventoryPage.validateProductNameSortAscend();
    }

    @When("user filter items based on {string}")
    public void userFilterItemsBasedOn(String filter) {
        inventoryPage.sortProducts(filter);
    }

    @Then("user see item list sorted by price in descending order")
    public void userSeeItemListSortedByPriceInDescendingOrder() {
        inventoryPage.validateProductPriceSortDescend();
    }


    @When("user click {string} product")
    public void userClickProduct(String product) {
        inventoryPage.clickProduct(product);
    }

    @Then("user see product details displayed")
    public void userSeeProductDetailsDisplayed() {
        inventoryPage.validateProductDisplayed();
    }


    @And("items are sorted by price in descending order")
    public void itemsAreSortedByPriceInDescendingOrder() {
        inventoryPage.validateProductPriceSortDescend();
    }
}
