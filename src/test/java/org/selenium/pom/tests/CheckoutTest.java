package org.selenium.pom.tests;

import io.qameta.allure.*;
import org.selenium.pom.api.actions.AddToCartAPI;
import org.selenium.pom.api.actions.SignUpAPI;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Products;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.utils.FakerUtils;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Checkout Functionality")
@Feature("Verify Checkout Functionality with Guest and Login user")
public class CheckoutTest extends BaseTest {

    @Story("Checkout with Guest User")
    @Link("https://www.google.com")
    @Link(name = "allure", type = "mylink")
    @TmsLink("12345")
    @Issue("12345678")
    @Description("This is a Sample Description")
    @Test(description = "Verify Checkout Functionality using Bank Transfer with a Guest User")
    public void GuestCheckoutUsingDirectBankTransfer() throws IOException {
        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        AddToCartAPI addToCartAPI = new AddToCartAPI();
        BillingAddress billingAddress  = JacksonUtils.deserializedJson("myBillingAddress.json", BillingAddress.class);
        addToCartAPI.addToCart(1215,1);
        injectCookiesToBrowser(addToCartAPI.getCookies());

        checkoutPage.load().
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                clickOnPlaceOrderButton();
        Assert.assertEquals(checkoutPage.getSuccessMessageText(), "Thank you. Your order has been received.");
    }
    @Story("Checkout with Login User")
    @Link("https://www.google.com")
    @Link(name = "allure", type = "mylink")
    @Description("This is a Sample Description")
    @Test(description = "Verify Checkout Functionality using Bank Transfer with a Logged in User")
    public void LoginAndCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
        BillingAddress billingAddress  = JacksonUtils.deserializedJson("myBillingAddress.json", BillingAddress.class);
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User().
                setUserName(username).
                setPassword("demopwd").
                setEmail(username + "@gmail.com");
        SignUpAPI signUpAPI = new SignUpAPI();
        signUpAPI.register(user);
        AddToCartAPI addToCartAPI = new AddToCartAPI(signUpAPI.getCookies());
        Products products = new Products(1215);
        addToCartAPI.addToCart(products.getId(), 1);


        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        Thread.sleep(5000);
        injectCookiesToBrowser(signUpAPI.getCookies());
        checkoutPage.load().
        setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                clickOnPlaceOrderButton();
        Assert.assertEquals(checkoutPage.getSuccessMessageText(), "Thank you. Your order has been received.");
    }
}
