package michaelclement.eu.pages.cart;

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


    public List<String> getProductNames(List<WebElement> productNames) {
        List<String> names = new ArrayList<>();
        for (WebElement element : productNames) {
            names.add(element.getText());
        }
        return names;
    }

    public List<Integer> getProductQuantities(List<WebElement> quantities) {
        List<Integer> quantity = new ArrayList<>();
        for (WebElement element : quantities) {
            quantity.add(parseInt(element.getText()));
        }
        return quantity;
    }

    public List<Integer> getSubTotalPrices() {
        List<Integer> prices = new ArrayList<>();
        for (WebElement element : totalPrices) {
            prices.add(
                    parseInt(element.getText().substring(1))
            );
        }
        return prices;
    }

    public List<Integer> getPrices() {
        List<Integer> itemPrices = new ArrayList<>();
        for (WebElement element : productPrices) {
            itemPrices.add(
                    parseInt(element.getText().substring(1))
            );
        }
        return itemPrices;
    }

    public void addOneRandomProductToCart() {
        int index = RANDOM.nextInt(plusButtons.size());
        plusButtons.get(index).click();
    }

    public Integer getCartTotalPrice() {
        return parseInt(cartTotalPrice.getText().substring(1));
    }

    public void clickCheckout() {
        waitHelper.click(checkoutButton);
    }

    public void emptyCart() {
        while (!isCartEmpty()) {
            waitHelper.click(minusButtons.getFirst());
        }
    }

    public boolean isCartEmpty() {
        return waitHelper.waitForElementPresent(singleMinusButton);
    }

    public boolean areCalculationsCorrect() {
           Integer cartTotal = getCartTotalPrice();
           Integer testCartTotal = 0;
        for (int i = 0; i < quantityElements.size(); i++){
           Integer quantity = Integer.parseInt(quantityElements.get(i).getDomProperty("value")); //nem lehet null
           Integer itemPrice = getPrices().get(i);
           Integer subtotal = getSubTotalPrices().get(i);
           if (quantity*itemPrice != subtotal) return false;
           testCartTotal += subtotal;
        }
        return testCartTotal.equals(cartTotal);
    }
}
