package test.e2e;

import Model.UserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import page.object.login.LoginPage;

import java.util.List;

public class FirstTest {
    WebDriver DRIVER = new ChromeDriver();

    private final LoginPage loginPage = new LoginPage();


    private final By USERNAME_FIELD_BY = By.xpath("//input[@id='username']");
    private final By PASSWORD_FIELD_BY = By.xpath("//input[@id='password']");
    private final By LOGIN_BUTTON_BY = By.xpath("//button[@type='submit']");


    public void sdgfasdf(){
        loginPage.login(UserType.INVALID_USERNAME);
    }

    @BeforeEach
    public void setUp() {
        DRIVER = new ChromeDriver();
        DRIVER.manage().window().maximize();

    }

    @Test
    public void loginInvalidAssert() throws InterruptedException {
        successfulLogin();
        DRIVER.switchTo().alert().dismiss();
        Assertions.assertDoesNotThrow(() -> DRIVER.findElement(USERNAME_FIELD_BY));
    }

    @Test
    public void loginTest() throws InterruptedException {
        DRIVER.get("https://www.michaelclement.eu/practice-webshop-login/");
        WebElement usernameField = DRIVER.findElement(USERNAME_FIELD_BY);
        usernameField.sendKeys("practiceUer");
        WebElement passwordField = DRIVER.findElement(PASSWORD_FIELD_BY);
        passwordField.sendKeys("practicePass");
        WebElement loginButton = DRIVER.findElement(LOGIN_BUTTON_BY);
        loginButton.click();
        Assertions.assertThrows(NoSuchElementException.class, () -> DRIVER.findElement(USERNAME_FIELD_BY));
    }


    @Test
    public void addToCartDeleteFromCart() throws InterruptedException {
        successfulLogin();
        WebElement plusButton = DRIVER.findElement(By.xpath("//div[@data-product-id='2']//button[@class='plus-button']"));
        for (int i = 0; i < 3; i++) {
            plusButton.click();
        }
        WebElement cartBadge = DRIVER.findElement(By.xpath("//span[@class='cart-badge']"));
        Assertions.assertEquals(3, Integer.parseInt(cartBadge.getText().trim()));
        WebElement minusButton = DRIVER.findElement(By.xpath("//div[@data-product-id='2']//button[@class='minus-button']"));
        for (int i = 0; i < 3; i++) {
            minusButton.click();
        }
        Assertions.assertEquals("", cartBadge.getText());
    }

    private void successfulLogin() throws InterruptedException {
        DRIVER.get("https://www.michaelclement.eu/practice-webshop-login/");
        DRIVER.manage().window().setSize(new Dimension(2800, 2000));
        WebElement usernameField = DRIVER.findElement(USERNAME_FIELD_BY);
        usernameField.sendKeys("practiceUser");
        WebElement passwordField = DRIVER.findElement(PASSWORD_FIELD_BY);
        passwordField.sendKeys("practicePass");
        WebElement loginButton = DRIVER.findElement(LOGIN_BUTTON_BY);
        loginButton.click();
    }

    @Test
    public void addTwoProductsToCartAndCheckout() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        successfulLogin();

        WebElement plusButton1 = DRIVER.findElement(By.xpath("//div[@data-product-id='2']//button[@class='plus-button']"));
        WebElement plusButton2 = DRIVER.findElement(By.xpath("//div[@data-product-id='4']//button[@class='plus-button']"));
        plusButton1.click();
        plusButton2.click();
        WebElement cartButton = DRIVER.findElement(By.xpath("//div[@class='shopping-cart']"));
        cartButton.click();
        WebElement totalPrice = DRIVER.findElement(By.xpath("//td[@data-test-id='cart-total-price']"));

        String price = totalPrice.getText(); //22
        String expectedPrice = "$22";

        softAssert.assertEquals(price, expectedPrice);

        WebElement checkoutButton = DRIVER.findElement(By.xpath("//button[@class='table-right-button']"));
        checkoutButton.click();

        //inputFields-eket listába teszem
        List<WebElement> inputFields = List.of(
                DRIVER.findElement(By.xpath("//input[@id='first-name']")),
                DRIVER.findElement(By.xpath("//input[@id='last-name']")),
                DRIVER.findElement(By.xpath("//input[@id='address-line-1']")),
                DRIVER.findElement(By.xpath("//input[@id='address-line-2']")),
                DRIVER.findElement(By.xpath("//input[@id='city']")),
                DRIVER.findElement(By.xpath("//input[@id='zip-code']")),
                DRIVER.findElement(By.xpath("//input[@id='email']"))
        );
        //ezeket változókba
        List<String> testInputs = List.of(
                "John", //firstname
                "Wick",
                "Maple Str. 1",
                "Suite B",
                "Newer York",
                "34231",
                "asd@asd.hu");

        //ciklusban beleírjuk
        for (int i = 0; i < inputFields.size(); i++) {
            inputFields.get(i).sendKeys(testInputs.get(i));
        }

        //országválasztás és összegzés gombra katt
        DRIVER.findElement(By.xpath("//select")).click();
        DRIVER.findElement(By.xpath("//option[@value='Hungary']")).click();
        DRIVER.findElement(By.xpath("//button[@class='table-right-button']")).click();

        //egyezik-e a summary a tesztadatokkal | 7 + 1 adat
        List<String> actualInputsExceptCountry = List.of(
                DRIVER.findElement(By.xpath("//td[@data-test-id='firstname']")).getText(),
                DRIVER.findElement(By.xpath("//td[@data-test-id='lastname']")).getText(),
                DRIVER.findElement(By.xpath("//td[@data-test-id='address-line1']")).getText(),
                DRIVER.findElement(By.xpath("//td[@data-test-id='address-line2']")).getText(),
                DRIVER.findElement(By.xpath("//td[@data-test-id='city']")).getText(),
                DRIVER.findElement(By.xpath("//td[@data-test-id='zip']")).getText(),
                DRIVER.findElement(By.xpath("//td[@data-test-id='email']")).getText()
        );

        //első hét tesztadat összehasonlítása
        for (int i = 0; i < inputFields.size(); i++) {
            softAssert.assertEquals(actualInputsExceptCountry.get(i), testInputs.get(i));
        }

        //ország összehasonlítása
        String actualCountry = DRIVER.findElement(By.xpath("//td[@data-test-id='country']")).getText();
        softAssert.assertEquals(actualCountry, "Hungary");

        //rendelés sikerességének megerősítése
        DRIVER.findElement(By.xpath("//button[@id='order']")).click();

        String expectedOrderStatus = "Thank you for your order!";
        String actualOrderStatus = DRIVER.findElement(By.xpath("//h3[contains(@class, 'has-text-align-center')]")).getText();
        softAssert.assertEquals(actualOrderStatus, expectedOrderStatus);

        softAssert.assertAll();
    }

    @AfterEach
    public void tearDown() {
        DRIVER.close();

    }


}
