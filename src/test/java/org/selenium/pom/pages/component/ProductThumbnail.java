package org.selenium.pom.pages.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.HomePage;

public class ProductThumbnail extends BasePage {

    private final By viewCartBtn = By.xpath("//a[@title='View cart']");

    public ProductThumbnail(WebDriver driver) {
        super(driver);
    }

    public ProductThumbnail clickOnAddToCartButton(String productName){
        By addToCartBtn = getAddToCartButtonElement(productName);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
//        driver.findElement(addToCartBtn).click();
        return this;
    }

    private By getAddToCartButtonElement(String productName){
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

    public CartPage clickOnViewCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
//        driver.findElement(viewCartBtn).click();
        return new CartPage(driver);
    }
}
