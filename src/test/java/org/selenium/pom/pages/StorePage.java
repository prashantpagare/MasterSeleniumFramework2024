package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.component.ProductThumbnail;

import java.io.IOException;

public class StorePage extends BasePage {

    private final By searchFld = By.xpath("//input[@type='search']");
    private final By searchBtn = By.xpath("//button[@value='Search']");
    private final By searchTitle = By.cssSelector("h1[class$='title']");

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    //    private final By viewCartBtn = By.xpath("//a[@title='View cart']"); (Created Composition)
    private ProductThumbnail productThumbnail;


    public StorePage(WebDriver driver){
        super(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    public boolean checkURL(){
        return wait.until(ExpectedConditions.urlContains("/store"));
    }

    public StorePage enterTextInSearchField(String productName){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld));
        e.clear();
        e.sendKeys(productName);
//        driver.findElement(searchFld).sendKeys(productName);
        return this;
    }

    public StorePage clickOnSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
//        driver.findElement(searchBtn).click();
        return this;
    }

    public StorePage search(String productName){
        enterTextInSearchField(productName).clickOnSearchButton(); // Functional
//        driver.findElement(searchFld).sendKeys(productName);
//        driver.findElement(searchBtn).click();
        return this;
    }

    public String getSearchResultTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchTitle)).getText();
//        return driver.findElement(searchTitle).getText();
    }

/*    public StorePage clickOnAddToCartButton(String productName){
        By addToCartBtn = getAddToCartButtonElement(productName);
        driver.findElement(addToCartBtn).click();
        return this;
    }

    private By getAddToCartButtonElement(String productName){
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

    public CartPage clickOnViewCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
//        driver.findElement(viewCartBtn).click();
        return new CartPage(driver);
    }*/

    public StorePage load(){
        load("/store");
        return this;
    }


}
