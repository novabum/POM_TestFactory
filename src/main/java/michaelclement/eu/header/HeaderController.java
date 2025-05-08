package michaelclement.eu.header;

import org.openqa.selenium.WebDriver;

public class HeaderController extends HeaderElements {
    public HeaderController(WebDriver driver) {
        super(driver);
    }

    public void clickLogoutButton() {
        waitHelper.click(logoutButton);
    }


}
