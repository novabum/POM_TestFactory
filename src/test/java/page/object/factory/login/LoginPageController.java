package page.object.factory.login;

import Model.MyUser;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageController extends LoginPageElements {

       private final WebDriverWait wait;

    public LoginPageController(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofMillis(3000));
    }

    public void login(MyUser myUser){
        fillUsernameField(myUser.username());
        fillPasswordField(myUser.password());
        clickLoginButton();
    }


    private void fillUsernameField(String username) {
        //implicit wait vár, x másodpercet, ha exceptiont kap, majd újra próbálkozik Mindenhol vár, nem nálunk van a kontroll
        try {
            wait.until(ExpectedConditions.elementToBeClickable(usernameField));
            usernameField.sendKeys(username);
        } catch (TimeoutException e) { //!!! Seleniumos exception kell)
            throw new RuntimeException(e); //tehetünk vele amit akarunk
        }

        //timeout exception-el tud eldobódni ezért try-ba tesszük
    }

    private void fillPasswordField(String password) { passwordField.sendKeys(password);
    }

    private void clickLoginButton() {
    }

//    private void setUsername(){
//        if (usernameField == null) {
//            usernameField = driver.findElement(USERNAME_FIELD_BY);
//        }
//    }

}
