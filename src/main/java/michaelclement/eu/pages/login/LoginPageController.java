package michaelclement.eu.pages.login;

import michaelclement.eu.data.MyUser;
import michaelclement.eu.util.Dependencies;
import michaelclement.eu.util.WaitHelper;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageController extends LoginPageElements {

    public LoginPageController(WebDriver driver) {
        super(driver);
    }

    public void login(MyUser myUser) {
        fillUsernameField(myUser.username());
        fillPasswordField(myUser.password());
        clickLoginButton();
    }

    private void fillUsernameField(String username) {
        waitHelper.fillTextField(usernameField, username);
    }

    private void fillPasswordField(String password) {
       waitHelper.fillTextField(passwordField, password);
    }

    private void clickLoginButton() {
        waitHelper.click(loginButton);
    }


}

//    private void fillUsernameField(String username) {
//        //implicit wait vár, x másodpercet, ha exceptiont kap, majd újra próbálkozik Mindenhol vár, nem nálunk van a kontroll
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(usernameField));
//            usernameField.sendKeys(username);
//        } catch (TimeoutException e) { //!!! Seleniumos exception kell)
//            throw new RuntimeException(e); //tehetünk vele amit akarunk
//        }
//
//        //timeout exception-el tud eldobódni ezért try-ba tesszük
//    }


//    private void setUsername(){
//        if (usernameField == null) {
//            usernameField = driver.findElement(USERNAME_FIELD_BY);
//        }
//    }

