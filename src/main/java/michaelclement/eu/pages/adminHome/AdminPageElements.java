package michaelclement.eu.pages.adminHome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPageElements {

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
        PageFactory.initElements(driver, this);
    }

}
