package michaelclement.eu.pages.product;

import michaelclement.eu.util.Dependencies;
import michaelclement.eu.pages.PageParent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPageElements extends PageParent {
    @FindBy(xpath = "//input[@id='product-search]")
    protected WebElement searchProductsInput;

    @FindBy(xpath = "//input[@id='min-price']")
    protected WebElement minimumPriceFilterInput;

    @FindBy(xpath = "//input[@id='max-price']")
    protected WebElement maximumPriceFilterInput;

    @FindBy(xpath = "//select[@id='sort-by']")
    protected WebElement sortByDropdown;

    @FindBy(xpath = "//option[@value='name']")
    protected WebElement sortByNameOption;

    @FindBy(xpath = "//option[@value='price']")
    protected WebElement sortByPriceOption;

    @FindBy(xpath = "//div[@class='product-card']/h3")
    protected List<WebElement> productTitles;

    @FindBy(xpath = "//div[@class='product-card']/p[1]")
    protected List<WebElement> productDescriptions;

    @FindBy(xpath = "//div[@class='product-card']/p[2]")
    protected List<WebElement> productPrices;

    @FindBy(xpath = "//*[@id=\"post-973\"]/div/nav/div/i")
    protected WebElement cartButton;

    @FindBy(xpath = "//button[@class='plus-button']")
    protected List<WebElement> plusButtons;

    @FindBy(xpath = "//button[@class='minus-button']")
    protected List<WebElement> minusButtons;

    public ProductsPageElements(WebDriver driver) {
        super(Dependencies.getWaitHelper(driver), driver);
        PageFactory.initElements(driver, this);
    }
}