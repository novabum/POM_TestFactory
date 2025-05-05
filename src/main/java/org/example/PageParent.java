package org.example;

import org.example.di.Dependencies;
import org.example.util.WaitHelper;
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
