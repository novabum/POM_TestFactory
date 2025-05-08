package michaelclement.eu.pages.cart;

import michaelclement.eu.pages.PageParent;
import michaelclement.eu.util.Dependencies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPageElements extends PageParent {
    @FindBy (xpath = "//td[@data-test-id='table-product-name']")
    protected List<WebElement> productNames;

    @FindBy (xpath = "//input[@class='quantity-input']")
    protected List<WebElement> productQuantities;

    @FindBy (xpath = "//td[@data-test-id='table-price']")
    protected List<WebElement> productPrices;

    @FindBy (xpath = "//td[@data-test-id='table-total-price']")
    protected List<WebElement> totalPrices;

    @FindBy (xpath = "//td[@data-test-id='cart-total-price']")
    protected WebElement cartTotalPrice;

    @FindBy(xpath = "//button[@class='plus-button']")
    protected List<WebElement> plusButtons;

    @FindBy(xpath = "//button[@class='minus-button']")
    protected List<WebElement> minusButtons;

    @FindBy(xpath = "//button[@class='minus-button']")
    protected WebElement singleMinusButton;

    @FindBy (xpath = "//a[@class='table-left-button']")
    protected WebElement backToProductsButton;

    @FindBy (xpath = "//button[@class='table-right-button']")
    protected WebElement checkoutButton;

    @FindBy(xpath = "//input[@class='quantity-input']")
    protected List<WebElement> quantityElements;

    public CartPageElements(WebDriver driver) {
        super(Dependencies.getWaitHelper(driver), driver);
        PageFactory.initElements(driver, this);
    }

}
