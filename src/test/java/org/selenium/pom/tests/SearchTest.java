package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchTest extends BaseTest {

    @Test(description = "Verify that the search product is visible after seaching for products")
    public void searchWithPartialMatch(){
        String searchItem = "Blue";
        StorePage storePage = new StorePage(getDriver()).load();
        storePage.checkURL();
        storePage.search(searchItem);
        Assert.assertEquals(storePage.getSearchResultTitle(), "Search results: “"+searchItem+"”");
    }
}
