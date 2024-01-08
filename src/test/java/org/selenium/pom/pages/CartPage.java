package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {

    /* private final By productName = By.xpath("//td[@class='product-name']");
    private final By checkoutBtn = By.cssSelector("a[href*='checkout']");*/
    private final By cartHeading = By.cssSelector(".has-text-align-center");

    @FindBy(xpath = "//td[@class='product-name']") private WebElement productName;
    @FindBy(css = "a[href*='checkout']") private WebElement checkoutBtn;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);   // use this on BasePage
    }

    public boolean verifyPageTitle(){
        return wait.until(ExpectedConditions.textToBe(cartHeading,"Cart"));
    }

    public String getProductNameLink(){
        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();  // PageFactory
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();  // POM
//        return driver.findElement(productName).getText();
    }

    public CheckoutPage clickOnCheckoutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
//        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
}
