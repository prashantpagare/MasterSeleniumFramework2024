package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Products;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyFirstTestCase extends BaseTest {

   // @Test(description = "E2E test as Guest User")
    public void GuestCheckoutUsingDirectBankTransfer() throws IOException {
        String searchItem = "Blue";
        BillingAddress billingAddress  = JacksonUtils.deserializedJson("myBillingAddress.json", BillingAddress.class);
        Products products = new Products(1215);

       /* BillingAddress billingAddress = new BillingAddress().
                setFirstName("demo").
                setLastName("user").
                setAddressLineOne("San Francisco").
                setCity("San Francisco").
                setPostCode("94188").
                setEmail("demo121@gmail.com");

       Using POJO */
        /*
        BillingAddress billingAddress = new BillingAddress("demo",
                "user","San Francisco","San Francisco",
                "94188","demo121@gmail.com");
       Using Constructor
         */


        StorePage storePage = new HomePage(getDriver()).
                load().getMyHeader().
                navigateToStoreUsingMenu();

        storePage.checkURL();
        storePage.search(searchItem);

//        storePage.search("Blue");   // Functional
//        Assert.assertEquals(storePage.getSearchResultTitle(), "Search results: “"+searchItem+"”");
        Assert.assertEquals(storePage.getSearchResultTitle(), "Search results: “"+searchItem+"”");
        storePage.getProductThumbnail().clickOnAddToCartButton(products.getName());

        CartPage cartPage = storePage.getProductThumbnail().clickOnViewCartButton();
        cartPage.verifyPageTitle();
        Assert.assertEquals(cartPage.getProductNameLink(), products.getName());
        CheckoutPage checkoutPage = cartPage.
                clickOnCheckoutButton().
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                clickOnPlaceOrderButton();

        Assert.assertEquals(checkoutPage.getSuccessMessageText(), "Thank you. Your order has been received.");

//        storePage.enterTextInSearchField("Blue").
//                clickOnSearchButton(); // Structural

    }

    //@Test(description = "E2E test with a Guest User")
    public void LoginAndCheckoutUsingDirectBankTransfer() throws IOException {
        String searchItem = "Blue";
        BillingAddress billingAddress  = JacksonUtils.deserializedJson("myBillingAddress.json", BillingAddress.class);
        Products products = new Products(1215);
        User user = new User(ConfigLoader.getInstance().getUsername(),ConfigLoader.getInstance().getPassword());

        StorePage storePage = new HomePage(getDriver()).
                load().getMyHeader().
                navigateToStoreUsingMenu();

        storePage.checkURL();
        storePage.search(searchItem);

//        storePage.search("Blue");   // Functional
        Assert.assertEquals(storePage.getSearchResultTitle(), "Search results: “"+searchItem+"”");
        storePage.getProductThumbnail().clickOnAddToCartButton(products.getName());
        CartPage cartPage = storePage.getProductThumbnail().clickOnViewCartButton();
        cartPage.verifyPageTitle();
        Assert.assertEquals(cartPage.getProductNameLink(), products.getName());
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();
        checkoutPage.clickOnLoginLink();

        checkoutPage.login(user).
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                clickOnPlaceOrderButton();

        Assert.assertEquals(checkoutPage.getSuccessMessageText(), "Thank you. Your order has been received.");

    }
}