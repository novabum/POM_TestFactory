package org.example.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageElements {

    @FindBy (xpath = "//input[@id='first-name']")
    protected WebElement firstname;

    @FindBy (xpath = "//input[@id='last-name']")
    protected WebElement lastname;

    @FindBy (xpath = "//input[@id='address-line-1']")
    protected WebElement addressLine1;

    @FindBy (xpath = "//input[@id='address-line-1']")
    protected WebElement addressLine2;

    @FindBy (xpath = "//input[@id='city']")
    protected WebElement city;

    @FindBy (xpath = "//input[@id='email']")
    protected WebElement email;

    @FindBy (xpath = "//input[@id='zip-code']")
    protected WebElement zip;

    @FindBy (xpath = "//select[@id='country']")
    protected WebElement countryDropDown;

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

    public void CheckoutPageElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
