package michaelclement.eu.header;

import michaelclement.eu.pages.PageParent;
import michaelclement.eu.util.Dependencies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderElements extends PageParent {

    //Csak a webshopos elemek!

    @FindBy(xpath = "//button[@id='products-menu-button']")
    protected WebElement productsButton;

    @FindBy(xpath = "//button[@id='contact-menu-button']")
    protected WebElement contactButton;

    @FindBy(xpath = "//button[@id='dummy-menu-button']")
    protected WebElement dummyButton;

    @FindBy(xpath = "//button[@id='logout-menu-button']")
    protected WebElement logoutButton;


    public HeaderElements(WebDriver driver) {
        super(Dependencies.getWaitHelper(driver), driver);
        PageFactory.initElements(driver, this);
    }
}
