package page.object.factory.login;

import Model.MyUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageController extends LoginPageElements {

    public LoginPageController(WebDriver driver) {
        super(driver);
    }

    public void login(MyUser myUser){
        fillUsernameField(myUser.username());
        fillPasswordField(myUser.password());
        clickLoginButton();
    }


    private void fillUsernameField(String username) {
        setUsername();
        usernameField.sendKeys(username);
    }

    private void fillPasswordField(String password) { passwordField.sendKeys(password);
    }

    private void clickLoginButton() {
    }

    private void setUsername(){
        if (usernameField == null) {
            usernameField = driver.findElement(USERNAME_FIELD_BY);
        }
    }

}
