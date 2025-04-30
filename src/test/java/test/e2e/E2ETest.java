package test.e2e;

import Util.DriverFactory;
import org.example.products.ProductsPageController;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.object.factory.login.LoginPageController;

public class E2ETest {
    WebDriver driver = DriverFactory.get();
    private final LoginPageController loginPage = new LoginPageController(driver);
    private final ProductsPageController productsPage = new ProductsPageController(driver);

    @Test
//    public void testE2EProcess(){
//        driver.get("");
//        loginPage.login(MyUserFactory.get(UserType.VALID));
//        productsPage.addNthProduct(product.index(2));
//
//        Assertions.assertEquals((4, productsPage.getNthProductCount()));
//    }
}
