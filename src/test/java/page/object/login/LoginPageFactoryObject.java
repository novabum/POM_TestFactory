package page.object.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactoryObject {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;
    //annotáljuk a fieldet a findby-al.

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    private void fillUsernameField(String username) {
        usernameField.sendKeys(username);
    }


    private void fillPasswordField(String password) {
        passwordField.sendKeys(password);
    }


    private void clickLoginButton() {
    }
}