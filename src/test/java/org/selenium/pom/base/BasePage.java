package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.utils.ConfigLoader;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    public void load(String endpoint){
        driver.get(ConfigLoader.getInstance().getBaseURL() + endpoint);
    }

    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("Overlay Size: " + overlays.size());
        if(overlays.size() > 0){
           wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("Overlay are Invisible");
        }else {
            System.out.println("Overlay not Found");
        }
    }
}
