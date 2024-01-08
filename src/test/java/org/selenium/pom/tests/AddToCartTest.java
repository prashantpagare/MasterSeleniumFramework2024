package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataproviders.MyDataProvider;
import org.selenium.pom.objects.Products;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Objects;

public class AddToCartTest extends BaseTest {

    @Test(description = "Navigate to Cart Page and add a Product")
    public void addToCartFromStorePage() throws IOException {
        Products products = new Products(1215);
        CartPage cartPage = new StorePage(getDriver()).load()
                .getProductThumbnail().clickOnAddToCartButton(products.getName())
                .clickOnViewCartButton();
        cartPage.verifyPageTitle();
        Assert.assertEquals(cartPage.getProductNameLink(), products.getName());
    }

    @Test(dataProvider = "getFeaturedProducts" , dataProviderClass = MyDataProvider.class)
    public void addToCartFromFeaturedProducts(Products products) throws IOException {
        CartPage cartPage = new HomePage(getDriver()).load().
                getProductThumbnail().clickOnAddToCartButton(products.getName()).
                clickOnViewCartButton();
        Assert.assertEquals(cartPage.getProductNameLink(), products.getName());
    }


}
