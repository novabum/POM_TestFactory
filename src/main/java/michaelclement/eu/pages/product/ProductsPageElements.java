package michaelclement.eu.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPageElements {
    @FindBy (xpath = "//input[@id='product-search]")
    protected WebElement searchProductsInput;

    @FindBy (xpath = "//input[@id='min-price']")
    protected WebElement minimumPriceFilterInput;

    @FindBy (xpath = "//input[@id='max-price']")
    protected WebElement maximumPriceFilterInput;

    @FindBy (xpath = "//select[@id='sort-by']")
    protected WebElement sortByDropdown;

    @FindBy (xpath = "//option[@value='name']")
    protected WebElement sortByNameOption;

    @FindBy (xpath = "//option[@value='price']")
    protected WebElement sortByPriceOption;

    @FindBy (xpath = "//div[@class='product-card']/h3")
    protected List<WebElement> productTitles;

    @FindBy (xpath = "//div[@class='product-card']/p")
    protected List<WebElement> productDescriptions;

public ProductsPageElements(WebDriver driver){
    PageFactory.initElements(driver, this);
}
}
