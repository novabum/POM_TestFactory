package michaelclement.eu.pages.order_confirmation;

import michaelclement.eu.pages.PageParent;
import michaelclement.eu.util.Dependencies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPageElements extends PageParent {

    @FindBy(xpath = "//*[@id=\"post-1254\"]/div/h3")
    WebElement thankYouForYourOrder;

    public ConfirmationPageElements(WebDriver driver) {
        super(Dependencies.getWaitHelper(driver), driver);
        PageFactory.initElements(driver, this);
    }
}
