package org.example.cart;

import org.openqa.selenium.WebElement;

import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CartPageController extends CartPageElements {

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

    public Integer getCartTotalPrice(WebElement cartTotalPrice){
        return parseInt(cartTotalPrice.getText().substring(1));
    }

}
