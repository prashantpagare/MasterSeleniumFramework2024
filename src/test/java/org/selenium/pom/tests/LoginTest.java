package org.selenium.pom.tests;

import org.selenium.pom.api.actions.AddToCartAPI;
import org.selenium.pom.api.actions.SignUpAPI;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.Products;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test(description = "User logs in during checkout")
    public void loginDuringCheckout() throws IOException, InterruptedException {
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User().
                setUserName(username).
                setPassword("demopwd").
                setEmail(username + "@gmail.com");
        SignUpAPI signUpAPI = new SignUpAPI();
        signUpAPI.register(user);
        AddToCartAPI addToCartAPI = new AddToCartAPI();
        Products products = new Products(1215);
        addToCartAPI.addToCart(products.getId(), 1);


        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        Thread.sleep(5000);
        injectCookiesToBrowser(addToCartAPI.getCookies());
        checkoutPage.load();
        Thread.sleep(5000);
        checkoutPage.
                clickOnLoginLink().
                login(user);
        Thread.sleep(5000);
        Assert.assertTrue(checkoutPage.getProductName().contains(products.getName()));
    }
}
