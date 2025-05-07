package test.e2e;

import Util.DriverFactory;
import data.MyUserFactory;
import data.MyUserType;
import data.OrderFactory;
import data.OrderingUserFactory;
import michaelclement.eu.data.Order;
import michaelclement.eu.data.Product;
import michaelclement.eu.pages.admin.AdminPageController;
import michaelclement.eu.pages.cart.CartPageController;
import michaelclement.eu.pages.checkout.CheckoutPageController;
import michaelclement.eu.pages.product.ProductsPageController;
import michaelclement.eu.pages.summary.SummaryPageController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import michaelclement.eu.pages.login.LoginPageController;

public class E2ETest {
    WebDriver DRIVER = DriverFactory.get();
    private final LoginPageController loginPage = new LoginPageController(DRIVER);
    private final ProductsPageController productsPage = new ProductsPageController(DRIVER);
    private final AdminPageController adminPage = new AdminPageController(DRIVER);
    private final CartPageController cartPage = new CartPageController(DRIVER);
    private final CheckoutPageController checkoutPage = new CheckoutPageController(DRIVER);
    private final SummaryPageController summaryPage = new SummaryPageController(DRIVER);

    @BeforeEach
    public void setUp() {
        DRIVER.manage().window().maximize();
        DRIVER.get("https://www.michaelclement.eu/practice-webshop-login/");
    }

    @Test
    public void loginWithValidUser(){
        loginPage.login(MyUserFactory.get(MyUserType.VALID));
        Assertions.assertTrue(productsPage.isPracticeUserLoggedIn());
    }

    @Test
    public void loginWithAdminUser(){
        loginPage.login(MyUserFactory.get(MyUserType.VALID_ADMIN));
        Assertions.assertTrue(adminPage.isAdminUserLoggedIn());
    }


//!!!!!!!!!!!!!!!!!!!!!
    @Test
    public void orderRandomProductAndCheckIfDetailsMatch(){
        loginWithValidUser();
        Product expectedProduct = productsPage.chooseRandomProduct();
        productsPage.orderProduct(expectedProduct, 2);
        productsPage.clickCartButton();
        cartPage.clickCheckout();
        checkoutPage.fillCheckoutForm(OrderingUserFactory.getRandom());
        checkoutPage.clickSummaryButton();

    }






    @AfterEach
    public void tearDown() {
        DRIVER.close();
    }
}

// JEGYZETEK
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