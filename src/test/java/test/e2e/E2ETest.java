package test.e2e;

import Util.DriverFactory;
import michaelclement.eu.pages.product.ProductsPageController;
import org.openqa.selenium.WebDriver;
import michaelclement.eu.pages.login.LoginPageController;

public class E2ETest {
    WebDriver driver = DriverFactory.get();
    private final LoginPageController loginPage = new LoginPageController(driver);
    private final ProductsPageController productsPage = new ProductsPageController(driver);

//    @Test
//    public void testE2EProcess(){
//        driver.get("");
//        loginPage.login(MyUserFactory.get(UserType.VALID));
//        productsPage.addNthProduct(product.index(2));
//
//        Assertions.assertEquals((4, productsPage.getNthProductCount()));
//    }
}
