package michaelclement.eu.pages.admin;

import michaelclement.eu.pages.PageParent;
import michaelclement.eu.util.Dependencies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPageElements extends PageParent {

    @FindBy (xpath = "//button[@class='add-product-button']")
    protected WebElement addProductButton;
    @FindBy (xpath = "//button[@class='save-button']")
    protected WebElement saveButton;

    @FindBy (xpath = "//input[@class='product-name']")
    protected List<WebElement> productName;
    @FindBy (xpath = "//input[@class='product-description']")
    protected List<WebElement> productDescription;
    @FindBy (xpath = "//input[@class='product-price']")
    protected List<WebElement> productPrice;

    public AdminPageElements(WebDriver driver) {
        super(Dependencies.getWaitHelper(driver), driver);
        PageFactory.initElements(driver, this);
    }
}
