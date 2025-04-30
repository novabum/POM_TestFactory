package org.example.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelpter {

    private WebDriver driver;
    private final WebDriverWait wait;

    public void WaitHelper(WebDriver driver){
        this.driver = driver;
    }


    public WaitHelpter(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(3000));
    }

    public void  waitAndClick(WebElement element){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            throw new RuntimeException(e); // bla bla
        }
    }

    public void  waitAndType(WebElement element, String text){
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(text);
    }

    public String  getElementText(WebElement element){
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.elementToBeClickable(element),
                d -> !element.getText().isBlank() //arra várunk, hogy ne legyen üres
        ));
        return element.getText();

    }



}
