package page.object.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final By USERNAME_FIELD_BY = By.xpath("//input[@id='username']");
    private final By PASSWORD_FIELD_BY = By.xpath("//input[@id='password']");
    private final By LOGIN_BUTTON_BY = By.xpath("//button[@type='submit']");

    private final WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }



    public void login(String username, String password){
        fillUsernameField(username);
        fillPasswordField(password);
        clickLoginButton();
    }

    private void setUsername(){
        if (usernameField == 0)
    }

}
