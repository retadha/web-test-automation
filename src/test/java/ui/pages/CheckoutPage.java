package ui.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {

    WebDriver driver;
    CartPage cartPage;

    String checkoutFormPage = "https://www.saucedemo.com/checkout-step-one.html";
    By firstNameField = By.cssSelector("input#first-name");
    By lastNameField = By.cssSelector("input#last-name");
    By postalCodeField = By.cssSelector("input#postal-code");
    By continueButton = By.cssSelector("input#continue");
    WebElement errorMessageContainer;

    String overviewPage = "https://www.saucedemo.com/checkout-step-two.html";
    By item = By.className("cart_item");
    By paymentInfoValue = By.cssSelector("[data-test='payment-info-value']");
    By shippingInfoValue = By.cssSelector("[data-test='shipping-info-value']");
    By totalLabel = By.className("summary_total_label");

    By finishButton = By.cssSelector("button#finish");
    By completeText = By.className("complete-text");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.cartPage = new CartPage(driver);
    }



    public void inputFirstName(String firstName) {
        this.driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        this.driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode) {
        this.driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void continueCheckout() {
        WebElement continueCheckout = this.driver.findElement(continueButton);
        continueCheckout.click();
    }

    public void validateErrorMessageDisplayed(String expectedErrorMessage) {
        errorMessageContainer = driver.findElement(By.className("error-message-container"));
        String errorMessage = errorMessageContainer.getText();

        Assertions.assertTrue(errorMessageContainer.isDisplayed());
        Assertions.assertEquals(expectedErrorMessage, errorMessage);

    }

    public List<WebElement> getItems() {
        return this.driver.findElements(item);
    }

    public void validateItemNumber(int cartNumber) {
        List<WebElement> items = this.getItems();
        Assertions.assertEquals(cartNumber, items.size());
    }

    public void validateItemsDisplayed() {
        List<WebElement> items = this.getItems();
        items.forEach(item -> Assertions.assertTrue(item.isDisplayed()));
    }

    public void validatePaymentInfoDisplayed() {
        WebElement paymentInfo = driver.findElement(paymentInfoValue);
        Assertions.assertTrue(paymentInfo.isDisplayed());
    }

    public void validateShippingInfoDisplayed() {
        WebElement paymentInfo = driver.findElement(shippingInfoValue);
        Assertions.assertTrue(paymentInfo.isDisplayed());
    }

    public void validateTotalPriceDisplayed() {
        WebElement totalPrice = driver.findElement(totalLabel);
        Assertions.assertTrue(totalPrice.isDisplayed());
    }

    public void validateDetailsDisplayed() {
        this.validateItemsDisplayed();
        this.validatePaymentInfoDisplayed();
        this.validateShippingInfoDisplayed();
        this.validateTotalPriceDisplayed();
    }

    public void finishCheckout() {
        WebElement finish = this.driver.findElement(finishButton);
        finish.click();

    }

    public void validateCheckoutCompleteMessageDisplayed(String expectedCompleteMessage) {
        WebElement complete = driver.findElement(completeText);
        String completeMessage = complete.getText();

        Assertions.assertTrue(complete.isDisplayed());
        Assertions.assertEquals(expectedCompleteMessage, completeMessage);

    }















}
