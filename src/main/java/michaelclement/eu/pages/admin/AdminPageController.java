package michaelclement.eu.pages.admin;

import michaelclement.eu.data.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPageController extends AdminPageElements {

    public AdminPageController(WebDriver driver) {
        super(driver);
    }

    public boolean isAdminUserLoggedIn() {
        return waitHelper.waitForElementPresent(addProductButton);
    }

    public void clickAddProductNTimes(Integer number) {
        for (int i = 0; i < number; i++) {
            addProductButton.click();
        }
    }

    //clear?
    public void clearTextFields(List<WebElement> listOfTextFields) {
        for (WebElement element : listOfTextFields) {
            element.clear();
        }
    }

    public void clickSaveButton() {
        waitHelper.click(saveButton);
    }

    public void clickAddProductButton(){
        waitHelper.click(addProductButton);
    }

    public void fillProductDetails(Product product) {
        waitHelper.fillTextField(productName.get(0), product.getName());
        waitHelper.fillTextField(productDescription.get(0), product.getDescription());
        waitHelper.fillTextField(productPrice.get(0), product.getPrice().toString());
    }

    public void clickLogOutButton() {
        waitHelper.click(logOutButton);
    }
}
