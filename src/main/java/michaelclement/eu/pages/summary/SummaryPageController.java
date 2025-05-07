package michaelclement.eu.pages.summary;

import michaelclement.eu.Dependencies;
import michaelclement.eu.util.WaitHelper;
import org.openqa.selenium.WebDriver;

public class SummaryPageController extends SummaryPageElements {

    private final WaitHelper waitHelper;

    public SummaryPageController(WebDriver driver) {
        super(driver);
        waitHelper = Dependencies.getWaitHelper(driver);
    }
}
