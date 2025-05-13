package test.e2e;

import Util.DriverFactory;
import com.beust.ah.A;
import data.MyUserFactory;
import data.MyUserType;
import data.OrderingUserFactory;
import data.ProductFactory;
import michaelclement.eu.data.OrderedProduct;
import michaelclement.eu.data.OrderingUser;
import michaelclement.eu.data.Product;
import michaelclement.eu.header.HeaderController;
import michaelclement.eu.pages.admin.AdminPageController;
import michaelclement.eu.pages.cart.CartPageController;
import michaelclement.eu.pages.checkout.CheckoutPageController;
import michaelclement.eu.pages.order_confirmation.ConfirmationPageController;
import michaelclement.eu.pages.product.ProductsPageController;
import michaelclement.eu.pages.product.SortType;
import michaelclement.eu.pages.summary.SummaryPageController;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import michaelclement.eu.pages.login.LoginPageController;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;


import java.util.Objects;

public class E2ETest {
    WebDriver DRIVER = DriverFactory.get();

    private final LoginPageController loginPage = new LoginPageController(DRIVER);
    private final ProductsPageController productsPage = new ProductsPageController(DRIVER);
    private final AdminPageController adminPage = new AdminPageController(DRIVER);
    private final CartPageController cartPage = new CartPageController(DRIVER);
    private final CheckoutPageController checkoutPage = new CheckoutPageController(DRIVER);
    private final SummaryPageController summaryPage = new SummaryPageController(DRIVER);
    private final ConfirmationPageController confirmationPage = new ConfirmationPageController(DRIVER);
    private final HeaderController header = new HeaderController(DRIVER);

    @BeforeEach
    public void setUp() {
        DRIVER.manage().window().setSize(new Dimension(1920, 1080));
        DRIVER.get("https://www.michaelclement.eu/practice-webshop-login/");
        loginPage.clickAcceptButton();
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

    @Test
    public void loggedOutUserCannotAccessProtectedPageTest(){
        loginWithValidUser();
        header.clickLogoutButton();
        DRIVER.get("https://www.michaelclement.eu/practice-webshop-products/");
        Assertions.assertTrue(Objects.requireNonNull(DRIVER.getCurrentUrl()).contains("-login"));

    }

    @Test
    public void orderXNumberOfOneRandomProductAndCheckIfTheirDetailsMatchTest(){
        loginWithValidUser();
        Product productToOrder = productsPage.chooseRandomProduct();
        //külön kezelem a productot és az orderedproductot, ezért itt konverzió történik:
        OrderedProduct expectedProduct = productsPage.addNumberOfThisProductToCart(productToOrder, 2);
        productsPage.clickCartButton();
        cartPage.clickCheckout();
        checkoutPage.fillCheckoutForm(OrderingUserFactory.getRandom());
        checkoutPage.clickSummaryButton();
        OrderedProduct orderedProduct = summaryPage.getFirstOrderedProduct();
        Assertions.assertEquals(expectedProduct, orderedProduct);
    }

    @Test
    public void checkIfOrderingUserDetailsMatchTest(){
        loginWithValidUser();
        productsPage.clickPlusNTimes(1,1);
        productsPage.clickCartButton();
        cartPage.clickCheckout();
        OrderingUser expectedOrderingUser = OrderingUserFactory.getRandom();
        checkoutPage.fillCheckoutForm(expectedOrderingUser);
        checkoutPage.clickSummaryButton();
        OrderingUser actualOrderingUser = summaryPage.getOrderingUser();
        Assertions.assertEquals(expectedOrderingUser, actualOrderingUser);
    }

    @Test
    public void checkIfOrderIsSuccessfulTest(){
        loginWithValidUser();
        productsPage.clickPlusNTimes(1,1);
        productsPage.clickCartButton();
        cartPage.clickCheckout();
        checkoutPage.fillCheckoutForm(OrderingUserFactory.getRandom());
        checkoutPage.clickSummaryButton();
        summaryPage.clickOrderButton();
        Assertions.assertTrue(confirmationPage.verifyOrderConfirmation());
    }

    @Test
    public void productSortByPriceTest(){
        loginWithValidUser();
        productsPage.sortBySelect(SortType.PRICE);
       Assertions.assertTrue(productsPage.arePricesSortedAlphabetically());
    }

    @Test
    public void productSortByNameTest(){
        loginWithValidUser();
        productsPage.sortBySelect(SortType.NAME);
        Assertions.assertTrue(productsPage.isSortedAlphabetically());
    }

    @Test
    public void deleteProductsFromCartTest(){
        loginWithValidUser();
        productsPage.addMaxTenRandomProductsToCart();
        productsPage.clickCartButton();
        cartPage.emptyCart();
        Assertions.assertTrue(cartPage.isCartEmpty());
    }

    //Ebbű ticket lesz :)
    @Test
    public void completeOrderWithoutProductsAddedToCartTest(){
        loginWithValidUser();
        productsPage.clickCartButton();
        cartPage.clickCheckout();
        checkoutPage.fillCheckoutForm(OrderingUserFactory.getRandom());
        checkoutPage.clickSummaryButton();
        summaryPage.clickOrderButton();
        Assertions.assertFalse(confirmationPage.verifyOrderConfirmation());
    }

    @Test
    public void productPageSearchFieldTest(){
        loginWithValidUser();
        String testString = "Michael's Notebook";
        productsPage.typeInSearchField(testString);
        Assertions.assertEquals(testString, productsPage.getTitles().getFirst());
    }

    @Test void priceFilterMinTest(){
        Double testPrice = 13.0;
        loginWithValidUser();
        productsPage.typeAndEnterPriceMinField(testPrice);
        Assertions.assertFalse(productsPage.isAnyPriceLowerThan(testPrice));
    }

    @Test void priceFilterMaxTest(){
        Double testPrice = 13.0;
        loginWithValidUser();
        productsPage.typeAndEnterPriceMaxField(testPrice);
        Assertions.assertTrue(productsPage.isAnyPriceLowerThan(testPrice));
    }

    @Test
    public void plusAndMinusButtonTest(){
        loginWithValidUser();
        productsPage.clickEveryAddToCartButton();
        productsPage.clickEveryRemoveFromCartButton();
        Assertions.assertTrue(productsPage.isEveryQuantityEqualsZero());
    }

    @Test
    public void calculationsInCartTest(){
        loginPage.clickAcceptButton();
        loginWithValidUser();
        int numberOfProducts = 10;
        productsPage.addRandomProductsToCart(numberOfProducts);
        productsPage.clickCartButton();
        Assertions.assertTrue(cartPage.areCalculationsCorrect());
    }

    @Test
    public void addNewProductOrderItAndCheckDetails(){
        SoftAssert softAssert = new SoftAssert();
        loginWithAdminUser();
        Product expectedProduct = ProductFactory.getRandom();
        adminPage.clickAddProductButton();
        adminPage.fillProductDetails(expectedProduct);
        adminPage.clickSaveButton();
        adminPage.clickLogOutButton();
        loginWithValidUser();
        productsPage.addNumberOfThisProductToCart(expectedProduct, 1);
        productsPage.clickCartButton();
        cartPage.clickCheckout();
        OrderingUser expectedOrderingUser = OrderingUserFactory.getRandom();
        checkoutPage.fillCheckoutForm(expectedOrderingUser);
        checkoutPage.clickSummaryButton();
        OrderingUser actualOrderingUser = summaryPage.getOrderingUser();
        summaryPage.clickOrderButton();

        softAssert.assertEquals(expectedOrderingUser, actualOrderingUser, "User mismatch");
        softAssert.assertTrue(confirmationPage.verifyOrderConfirmation(), "Ordered product mismatch");
        softAssert.assertAll();
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