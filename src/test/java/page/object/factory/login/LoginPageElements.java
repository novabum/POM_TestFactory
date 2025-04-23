package page.object.factory.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {

    @FindBy(xpath = "//input[@id='username']")
    protected WebElement usernameField;
    //annotáljuk a fieldet a findby-al.

    @FindBy(xpath = "//input[@id='password']")
    protected WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement loginButton;

    //ami fontos exception megelőzéséhez
    //A konstruktor megkapja a webdrivert, hogy inicializálni tudja az elemeket.
    public LoginPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
