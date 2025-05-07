package test.e2e;

import Util.DriverFactory;
import data.MyUserFactory;
import data.MyUserType;
import data.OrderFactory;
import michaelclement.eu.data.Order;
import michaelclement.eu.pages.checkout.CheckoutPageController;
import michaelclement.eu.pages.product.ProductsPageController;
import michaelclement.eu.pages.summary.SummaryPageController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import michaelclement.eu.pages.login.LoginPageController;

public class E2ETest {
    WebDriver driver = DriverFactory.get();
    private final LoginPageController loginPage = new LoginPageController(driver);
    private final ProductsPageController productsPage = new ProductsPageController(driver);

//    @Test
//


//    @Test
//    public void testSimpleOrderFlow() {
//        Order expectedOrder = OrderFactory.getRandom(2);
//        productsMenu header = new MenuController(driver);
//        CheckoutPageController checkoutPageController = new CheckoutPageController(driver);
//        SummaryPageController summaryPageController = new SummaryPageController(driver);
//
//        loginPage.login(MyUserFactory.get(MyUserType.VALID));
//        productsPage.addProductsToCart(expectedOrder.getProducts());
//        header.clickCartButton();
//        cartPageController.clickCheckoutButton();
//        checkoutPageController.fillCheckoutForm(expectedOrder.getOrderingUser());
//        checkoutPageController.clickSummaryButton();
//
//        Order actualOrder = summaryPageController.getOrder();
//
//        Assertions.assertEquals(expectedOrder, actualOrder);
//    }


//    @Test
//    public void testE2EProcess(){
//        driver.get("");
//        loginPage.login(MyUserFactory.get(UserType.VALID));
//        productsPage.addNthProduct(product.index(2));
//
//        Assertions.assertEquals((4, productsPage.getNthProductCount()));
//    }
}
