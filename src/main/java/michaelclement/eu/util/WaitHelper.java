package michaelclement.eu.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {

    private final WebDriver driver;
    private final WebDriverWait wait;

//    public WaitHelper(WebDriver driver){
//        this.driver = driver;
//    }

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(3000));
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void fillTextField(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public String getElementText(WebElement element) {
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.elementToBeClickable(element),
                d -> !element.getText().isBlank() //arra várunk, hogy ne legyen üres
        ));
        return element.getText();
    }

    public int getElementsCount(List<WebElement> elements) {
        try {
            wait.until(d -> !elements.isEmpty());
            return elements.size();
        } catch (TimeoutException e) {
            return 0;
        }
    }

    public void chooseDropdownOptionByValue(List<WebElement> dropDownOptions, String value) {
        dropDownOptions.stream()
                .filter(element -> value.equals(element.getText()))
                .toList()
                .get(0)
                .click();
    }

    public void waitUntilElementListIsNotEmpty(List<WebElement> elements) {
        wait.until(d -> !elements.isEmpty());
    }

    public boolean waitForElementPresent(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)) != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

