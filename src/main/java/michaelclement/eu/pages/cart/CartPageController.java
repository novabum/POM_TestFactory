package michaelclement.eu.pages.cart;

import michaelclement.eu.data.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class CartPageController extends CartPageElements {
    private static final Random RANDOM = new Random();

    public CartPageController(WebDriver driver) {
        super(driver);
    }



    public List<String> getProductNames(List<WebElement> productNames){
        List<String> names = new ArrayList<>();
        for (WebElement element : productNames){
            names.add(element.getText());
        }
        return names;
    }

    public List<Integer> getProductQuantities(List<WebElement> quantities){
        List<Integer> quantity = new ArrayList<>();
        for (WebElement element : quantities){
            quantity.add(parseInt(element.getText()));
        }
        return quantity;
    }

    public List<Integer> getTotalPrices(List<WebElement> totalPrices){
        List <Integer> prices = new ArrayList<>();
        for (WebElement element : totalPrices){
            prices.add(
              parseInt(element.getText().substring(1))
            );
        }
        return prices;
    }

    public void addOneRandomProductToCart(){
        int index = RANDOM.nextInt(plusButtons.size());
        plusButtons.get(index).click();
    }

    public Integer getCartTotalPrice(WebElement cartTotalPrice){
        return parseInt(cartTotalPrice.getText().substring(1));
    }

    public void clickCheckout() {
        waitHelper.click(checkoutButton);
    }
}
