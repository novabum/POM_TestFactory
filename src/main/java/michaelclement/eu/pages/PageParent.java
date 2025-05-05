package michaelclement.eu.pages;

import michaelclement.eu.di.Dependencies;
import michaelclement.eu.util.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageParent {

    protected final WaitHelper waitHelper;
    private final WebDriver driver;

    public PageParent(WaitHelper waitHelper, WebDriver driver) {
        this.driver = driver;
        this.waitHelper = Dependencies.getWaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUrl(){ return driver.getCurrentUrl();}
}
