package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.component.MyHeader;
import org.selenium.pom.pages.component.ProductThumbnail;

import java.io.IOException;

public class HomePage extends BasePage {

    private MyHeader myHeader;
    private ProductThumbnail productThumbnail;

    public MyHeader getMyHeader() {
        return myHeader;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    public HomePage(WebDriver driver) {
        super(driver);
        myHeader = new MyHeader(driver);
        productThumbnail = new ProductThumbnail(driver);
    }


    public HomePage load(){
        load("/");
        wait.until(ExpectedConditions.titleContains("AskOmDch"));
        return this;
    }

}
