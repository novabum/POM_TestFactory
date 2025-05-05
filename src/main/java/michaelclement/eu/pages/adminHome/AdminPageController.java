package michaelclement.eu.pages.adminHome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPageController extends AdminPageElements {

    public AdminPageController(WebDriver driver) {
        super(driver);
    }

    public void clickAddProductNTimes(Integer number){
        for (int i = 0; i < number; i++) {
            addProductButton.click();
        }
    }

    //clear?
    public void clearTextFields(List<WebElement> listOfTextFields){
        for (WebElement element : listOfTextFields){
            element.clear();
        }
    }



}
