package michaelclement.eu.util;


import org.openqa.selenium.WebDriver;

public final class Dependencies {
    private static WaitHelper waitHelper;
    private static WebDriver driver;

    //Singleton
    public static WaitHelper getWaitHelper(WebDriver driver) {
        if (waitHelper == null) {
            waitHelper = new WaitHelper(driver);
        }
        return waitHelper;
    }
}
