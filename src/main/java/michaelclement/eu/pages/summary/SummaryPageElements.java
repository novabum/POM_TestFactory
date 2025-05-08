package michaelclement.eu.pages.summary;

import michaelclement.eu.util.Dependencies;
import michaelclement.eu.pages.PageParent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SummaryPageElements extends PageParent {

    @FindBy (xpath = "//td[@data-test-id='firstname']")
    protected WebElement firstName;

    @FindBy (xpath = "//td[@data-test-id='lastname']")
    protected WebElement lastName;

    @FindBy (xpath = "//td[@data-test-id='email']")
    protected WebElement email;

    @FindBy (xpath = "//td[@data-test-id='address-line1']")
    protected WebElement addressLine1;

    @FindBy (xpath = "//td[@data-test-id='address-line2']")
    protected WebElement addressLine2;

    @FindBy (xpath = "//td[@data-test-id='city']")
    protected WebElement city;

    @FindBy (xpath = "//td[@data-test-id='country']")
    protected WebElement country;

    @FindBy (xpath = "//td[@data-test-id='zip']")
    protected WebElement zip;

    @FindBy (xpath = "//td[@data-test-id='product-name']")
    protected List<WebElement> productTitles;

    @FindBy (xpath = "//td[@data-test-id='quantity']")
    protected List<WebElement> productQuantities;

    @FindBy (xpath = "//td[@data-test-id='price']")
    protected List<WebElement> productPrices;

    @FindBy (xpath = "//td[@data-test-id='product-total-price']")
    protected List<WebElement> productSubTotals;

    @FindBy (xpath = "//td[@data-test-id='total-price']")
    protected WebElement totalPrice;

    @FindBy (xpath = "//button[@class='table-right-button']")
    protected WebElement orderButton;

    public SummaryPageElements(WebDriver driver) {
        super(Dependencies.getWaitHelper(driver), driver);
        PageFactory.initElements(driver, this);
    }

}
