package michaelclement.eu.pages.summary;

import michaelclement.eu.data.OrderedProduct;
import michaelclement.eu.data.Product;
import michaelclement.eu.util.Dependencies;
import michaelclement.eu.util.WaitHelper;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SummaryPageController extends SummaryPageElements {

    public SummaryPageController(WebDriver driver) {
        super(driver);
    }

    private List<OrderedProduct> getOrderedProducts() {
        List<OrderedProduct> productsOnSite = new ArrayList<>();
        for (int i = 0; i < productTitles.size(); i++) {
            String name = productTitles.get(i).getText();
            Integer quantity = Integer.parseInt(productQuantities.get(i).getText());
            Double price = Double.parseDouble(productPrices.get(i).getText().substring(1));
            Double totalPrice = Double.parseDouble(productSubTotals.get(i).getText().substring(1));
            productsOnSite.add(new OrderedProduct(name, quantity, price, totalPrice));
        }
        return productsOnSite;
    }

    public OrderedProduct getNthOrderedProduct(int index) {
        return getOrderedProducts().get(index);
    }


}
