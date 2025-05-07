package michaelclement.eu.pages.checkout;

import michaelclement.eu.util.Dependencies;
import michaelclement.eu.pages.PageParent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPageElements extends PageParent {

    @FindBy (xpath = "//input[@id='first-name']")
    protected WebElement firstnameInput;

    @FindBy (xpath = "//input[@id='last-name']")
    protected WebElement lastnameInput;

    @FindBy (xpath = "//input[@id='address-line-1']")
    protected WebElement addressLine1Input;

    @FindBy (xpath = "//input[@id='address-line-1']")
    protected WebElement addressLine2Input;

    @FindBy (xpath = "//input[@id='city']")
    protected WebElement cityInput;

    @FindBy (xpath = "//input[@id='email']")
    protected WebElement emailInput;

    @FindBy (xpath = "//input[@id='zip-code']")
    protected WebElement zipInput;

    @FindBy (xpath = "//select[@id='country']")
    protected WebElement countryDropDown;

    @FindBy (xpath = "//option[@data-test-id='country-option']")
    protected List<WebElement> countryDropDownOptions;

    @FindBy (xpath = "//option[@value='Hungary']")
    protected WebElement optionHungary;

    @FindBy (xpath = "//option[@value='Austria']")
    protected WebElement optionAustria;

    @FindBy (xpath = "//option[@value='Slovakia']")
    protected WebElement optionSlovakia;

    @FindBy (xpath = "//option[@value='Croatia']")
    protected WebElement optionCroatia;

    @FindBy (xpath = "//a[@class='table-left-button']")
    protected WebElement backToCartButton;

    @FindBy (xpath = "//button[@class='table-right-button']")
    protected WebElement summaryButton;

    public CheckoutPageElements(WebDriver driver) {
        super(Dependencies.getWaitHelper(driver), driver);
        PageFactory.initElements(driver, this);
    }

}
