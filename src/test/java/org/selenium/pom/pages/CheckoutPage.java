package org.selenium.pom.pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;
import org.selenium.pom.utils.ConfigLoader;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends BasePage {

    private final By fistNameTextFld = By.xpath("//input[@id='billing_first_name']");
    private final By lastNameTextFld =  By.xpath("//input[@id='billing_last_name']");
    private final By billingAddressTextFld = By.xpath("//input[@id='billing_address_1']");
    private final By billingCityTextFld = By.xpath("//input[@id='billing_city']");
    private final By billingPostcodeTextFld = By.xpath("//input[@id='billing_postcode']");
    private final By billingEmailTextFld = By.xpath("//input[@id='billing_email']");
    private final By placeOrderBtn = By.xpath("//button[@id='place_order']");
    private final By successMessage = By.cssSelector(".woocommerce-notice");
    private final By loginLink = By.xpath("//a[@class='showlogin']");
    private final By usernameTextFld = By.xpath("//input[@id='username']");
    private final By passwordTextFld = By.xpath("//input[@id='password']");
    private final By loginBtn = By.xpath("//button[@name='login']");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");
    private final By countryDropDown = By.xpath("//select[@id='billing_country']");
    private final By stateDropDown = By.xpath("//select[@id='billing_state']");
    private final By directBankTransfer = By.xpath("//input[@id='payment_method_bacs']");
    private final By cashOnDelivery = By.xpath("//input[@id='payment_method_cod']");
    private final By alternateCountryDropDown = By.id("select2-billing_country-container");
    private final By alternateStateDropDown = By.id("select2-billing_state-container");
    private final By productName = By.cssSelector("td[class='product-name']");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage load(){
        load("/checkout/");
        return this;
    }

    public CheckoutPage enterFirstName(String firstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(fistNameTextFld));
        e.clear();
        e.sendKeys(firstName);
//        driver.findElement(fistNameTextFld).clear();
//        driver.findElement(fistNameTextFld).sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameTextFld));
        e.clear();
        e.sendKeys(lastName);
//        driver.findElement(lastNameTextFld).clear();
//        driver.findElement(lastNameTextFld).sendKeys(lastName);
        return this;
    }
    public CheckoutPage enterBillingAddress(String billingAddress){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddressTextFld));
        e.clear();
        e.sendKeys(billingAddress);
//        driver.findElement(billingAddressTextFld).clear();
//        driver.findElement(billingAddressTextFld).sendKeys(billingAddress);
        return this;
    }
    public CheckoutPage enterBillingCity(String BillingCity){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityTextFld));
        e.clear();
        e.sendKeys(BillingCity);
//        driver.findElement(billingCityTextFld).clear();
//        driver.findElement(billingCityTextFld).sendKeys(BillingCity);
        return this;
    }
    public CheckoutPage enterBillingPostcode(String billingPostcode){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(billingPostcodeTextFld));
        e.clear();
        e.sendKeys(billingPostcode);
//        driver.findElement(billingPostcodeTextFld).clear();
//        driver.findElement(billingPostcodeTextFld).sendKeys(billingPostcode);
        return this;
    }
    public CheckoutPage enterbillingEmailText(String billingEmail){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmailTextFld));
        e.clear();
        e.sendKeys(billingEmail);
//        driver.findElement(billingEmailTextFld).clear();
//        driver.findElement(billingEmailTextFld).sendKeys(billingEmail);
        return this;
    }
    public CheckoutPage clickOnPlaceOrderButton(){
        waitForOverlaysToDisappear(overlay);
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getSuccessMessageText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
//        return driver.findElement(successMessage).getText();
    }

    public CheckoutPage clickOnLoginLink(){
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
//        driver.findElement(loginLink).click();
        return this;
    }

    private CheckoutPage enterUsername(String userName){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextFld));
        e.clear();
        e.sendKeys(userName);
//        driver.findElement(usernameTextFld).clear();
//        driver.findElement(usernameTextFld).sendKeys(userName);
        return this;
    }

    private CheckoutPage enterPassword(String password){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextFld));
        e.clear();
        e.sendKeys(password);
//        driver.findElement(passwordTextFld).clear();
//        driver.findElement(passwordTextFld).sendKeys(password);
        return this;
    }

    private CheckoutPage clickOnLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
//        driver.findElement(loginBtn).click();
        return this;
    }

//    public CheckoutPage login(String userName, String password){
//        enterUsername(userName);
//        enterPassword(password);
//        clickOnLoginButton();
//        return this;
//    }

    public CheckoutPage waitForLoginBtnToDisappear(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginBtn));
        return this;
    }

    public CheckoutPage login(User user){
        enterUsername(user.getUserName()).enterPassword(user.getPassword()).waitForLoginBtnToDisappear();
        return this;
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress){
        enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                selectCountry(billingAddress.getCountryName()).
                enterBillingAddress(billingAddress.getAddressLineOne()).
                enterBillingCity(billingAddress.getCity()).
                selectState(billingAddress.getStateName()).
                enterBillingPostcode(billingAddress.getPostCode()).
                enterbillingEmailText(billingAddress.getEmail());
        return this;
    }

    public CheckoutPage selectCountry(String countryName){
        /*Select select = new Select(driver.findElement(countryDropDown));
        select.selectByVisibleText(countryName);*/

        wait.until(ExpectedConditions.elementToBeClickable(alternateCountryDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+ countryName+"']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
        return this;
    }

    public CheckoutPage selectState(String stateName){
        /*Select select = new Select(driver.findElement(stateDropDown));
        select.selectByVisibleText(stateName);*/
        wait.until(ExpectedConditions.elementToBeClickable(alternateStateDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+ stateName+"']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();

        return this;
    }

    public CheckoutPage selectDirectBankTransfer(){
        WebElement radioBtn = wait.until(ExpectedConditions.elementToBeClickable(directBankTransfer));
        if(!radioBtn.isSelected()){
            radioBtn.click();
        }
        return this;
    }

    public CheckoutPage selectCashOnDelivery(){
        WebElement radioBtn = wait.until(ExpectedConditions.elementToBeClickable(cashOnDelivery));
        if(!radioBtn.isSelected()){
            radioBtn.click();
        }
        return this;
    }

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }
}
