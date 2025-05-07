package michaelclement.eu;


import michaelclement.eu.util.WaitHelper;
import org.openqa.selenium.WebDriver;

public final class Dependencies {
    private static WaitHelper waitHelper;
    private static WebDriver driver;

    public static WaitHelper getWaitHelper(WebDriver driver) {
        if (waitHelper == null) {
            waitHelper = new WaitHelper(driver);
        }
        return waitHelper;
    }
}
