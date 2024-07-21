package ui.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    WebDriver driver;
    String url = "https://www.saucedemo.com/cart.html";

    By cartButton = By.className("shopping_cart_link");
    By cartBadge = By.className("shopping_cart_badge");
    By cartItem = By.className("cart_item");
    By cartItemName = By.className("inventory_item_name");
    By checkoutButton = By.cssSelector("button#checkout");
    WebElement errorMessageContainer;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void validateCartBadgeDisplayed() {

        WebElement cart = driver.findElement(cartButton);
        WebElement badge = cart.findElement(cartBadge);

        Assertions.assertTrue(badge.isDisplayed());
    }

    public int getBadgeNumber() {
        WebElement badge = driver.findElement(cartBadge);
        int badgeNumber = Integer.valueOf(badge.getText());

        return badgeNumber;
    }

    public void validateBadgeNumber(int n) {
        Assertions.assertEquals(n,getBadgeNumber());
    }



    public List<WebElement> getItems() {
        List<WebElement> items = driver.findElements(cartItem);
        return items;
    }

    public int getItemNumber() {
        return this.getItems().size();
    }


    public List<String> getItemNames() {
        List<String> itemNames = this.getItems().stream()
                .map(item -> item.findElement(cartItemName).getText())
                .collect(Collectors.toList());
        return itemNames;
    }

    public void validateItemNumber(int n) {
        Assertions.assertEquals(n, getItemNumber());
    }

    public void removeFromCart(String product) {
        WebElement removeButton = this.getRemoveButton(product);
        removeButton.click();
    }

    public void validateEmptyCart() {
        Assertions.assertEquals(0, getItemNumber());
    }

    public void emptyCart() {
        this.driver.get(this.getUrl());
        List<String> items = this.getItemNames();
        items.forEach(item -> this.removeFromCart(item));
    }

    public WebElement getRemoveButton(String product) {

        String lowerCaseString = product.toLowerCase();
        String hyphenatedString = lowerCaseString.replace(" ", "-");
        String removeButtonId = "remove-" + hyphenatedString;

        WebElement removeButton = driver.findElement(By.id(removeButtonId));

        return removeButton;

    }

    public void checkout() {
        WebElement checkout = driver.findElement(checkoutButton);
        checkout.click();
    }

    public void validateErrorMessageDisplayed(String expectedErrorMessage) {
        errorMessageContainer = driver.findElement(By.className("error-message-container"));
        String errorMessage = errorMessageContainer.getText();

        Assertions.assertTrue(errorMessageContainer.isDisplayed());
        Assertions.assertEquals(expectedErrorMessage, errorMessage);

    }

    public void goToCartPage() {
        this.driver.get(this.getUrl());
    }






}
