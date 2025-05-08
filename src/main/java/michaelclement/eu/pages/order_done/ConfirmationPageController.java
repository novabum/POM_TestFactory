package michaelclement.eu.pages.order_done;

import org.openqa.selenium.WebDriver;

public class ConfirmationPageController extends ConfirmationPageElements {

    public ConfirmationPageController(WebDriver driver) {
        super(driver);
    }


    public boolean verifyOrderConfirmation() {
       return waitHelper.waitForElementPresent(thankYouForYourOrder);
    }
}
