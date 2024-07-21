package ui.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    By usernameInputField = By.cssSelector("input#user-name");
    By passwordInputField = By.cssSelector("input#password");
    By loginButton = By.id("login-button");
    String url = "https://www.saucedemo.com";
    WebElement errorMessageContainer;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public String getUrl() {
        return url;
    }

    public void inputUsername(String username) {
        driver.findElement(usernameInputField).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void validateErrorMessageDisplayed(String expectedErrorMessage) {
        errorMessageContainer = driver.findElement(By.className("error-message-container"));
        String errorMessage = errorMessageContainer.getText();

        Assertions.assertTrue(errorMessageContainer.isDisplayed());
        Assertions.assertEquals(expectedErrorMessage, errorMessage);

    }

    public void login() {
        this.driver.get(this.getUrl());
        this.inputUsername("standard_user");
        this.inputPassword("secret_sauce");
        this.clickLoginButton();
    }

    public void goToLoginPage() {
        driver.get(this.getUrl());
    }


}
