package ui.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage {

    WebDriver driver;
    String url = "https://www.saucedemo.com/inventory.html";

    By product = By.className("inventory_item");

    By productName = By.className("inventory_item_name");
    By productDesc = By.className("inventory_item_desc");
    By productPrice = By.className("inventory_item_price");

    By productNameDetail = By.className("inventory_details_name");
    By productDescDetail = By.className("inventory_details_desc");
    By productPriceDetail = By.className("inventory_details_price");
    By addtoCartButtonInProductDetail = By.cssSelector("button#add-to-cart");

    By sortButton = By.className("product_sort_container");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;

    }

    public String getUrl() {
        return url;
    }

    public void validateInInventoryPage() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(this.url, currentUrl);
    }

    public void validateProductsDisplayed() {
        List<WebElement> products = this.getProducts();

        for(WebElement product: products) {

            WebElement name = product.findElement(productName);
            WebElement desc = product.findElement(productDesc);
            WebElement price = product.findElement(productPrice);

            Assertions.assertTrue(name.isDisplayed());
            Assertions.assertTrue(desc.isDisplayed());
            Assertions.assertTrue(price.isDisplayed());

        }
    }




    public List<WebElement> getProducts() {
        List<WebElement> products = driver.findElements(product);
        return products;
    }


    public List<String> getProductNames() {
        List<String> productNames = this.getProducts().stream()
                                        .map(product -> product.findElement(productName).getText())
                                        .collect(Collectors.toList());
        return productNames;
    }

    public List<Double> getProductPrices() {
        List<WebElement> products = this.getProducts();

        List<Double> productPrices = products.stream()
                .map(product -> product.findElement(productPrice).getText())
                .map(price -> price.replace("$", "")) // Strip $ from the front of each price
                .map(Double::parseDouble) // Convert the string to double
                .collect(Collectors.toList());

        return productPrices;
    }

    public void sortProducts(String option) {
        WebElement sortElement = driver.findElement(sortButton);
        Select select = new Select(sortElement);
        select.selectByVisibleText(option);

    }

    public boolean validateProductNameSort() {

        List<String> productNames = this.getProductNames();
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);


        boolean isSortedAscend = productNames.equals(sortedProductNames);
        return isSortedAscend;

    }

    public void validateProductNameSortAscend() {
        Assertions.assertTrue(this::validateProductNameSort);
    }


    public boolean validateProductPriceSort() {

        List<Double> productPrices = this.getProductPrices();
        List<Double> sortedProductPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedProductPrices);

        boolean isSortedAscend = productPrices.equals(sortedProductPrices);
        return isSortedAscend;
    }

    public void validateProductPriceSortDescend() {
        Assertions.assertFalse(this::validateProductPriceSort);
    }

    public void clickProduct(String product) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + product + "')]"));
        element.click();
    }

    public void validateProductDisplayed() {
        WebElement name = driver.findElement(productNameDetail);
        WebElement desc = driver.findElement(productDescDetail);
        WebElement price = driver.findElement(productPriceDetail);

        Assertions.assertTrue(name.isDisplayed());
        Assertions.assertTrue(desc.isDisplayed());
        Assertions.assertTrue(price.isDisplayed());

    }

    public void addtoCart(String product) {

        clickProduct(product);

        WebElement addtoCartButton = driver.findElement(addtoCartButtonInProductDetail);
        addtoCartButton.click();


    }

    public void goToInventoryPage() {
        driver.get(this.getUrl());
    }










}
