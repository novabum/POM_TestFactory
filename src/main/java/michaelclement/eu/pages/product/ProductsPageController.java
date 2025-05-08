package michaelclement.eu.pages.product;

import michaelclement.eu.data.OrderedProduct;
import michaelclement.eu.data.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsPageController extends ProductsPageElements {
    private final Random RANDOM = new Random();
    public ProductsPageController(WebDriver driver) {
        super(driver);
    }
    public void clickCartButton() {
        waitHelper.click(cartButton);
    }

    public void selectSortType(SortType type) {
        sortByDropdown.click();
        switch (type) {
            case PRICE -> sortByPriceOption.click();
            case NAME -> sortByNameOption.click();
        }
    }

    public String getNthProductTitle(int index) {
        return productTitles.get(index).getText();
    }

    public List<String> getTitles() {
        return getElementsTexts(productTitles);
    }

    private List<String> getElementsTexts(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();
        for (WebElement element : productTitles)
            texts.add(element.getText());
        return texts;
    }

    public Product chooseRandomProduct() {
        int index = RANDOM.nextInt(plusButtons.size());
        return productsOnSite().get(index);
    }

    private List<Product> productsOnSite() {
        List<Product> productsOnSite = new ArrayList<>();
        for (int i = 0; i < productTitles.size(); i++) {
            String name = productTitles.get(i).getText();
            String desc = productDescriptions.get(i).getText();
            Double price = Double.parseDouble(productPrices.get(i).getText().substring(8));
            productsOnSite.add(new Product(name, desc, price));
        }
        return productsOnSite;
    }

    /**
     *Megrendelünk egy terméket. A termék közben orderedproduct-á válik, hiszen lesz mennyisége és subtotálja
     */

    public OrderedProduct orderProduct(Product product, int quantity) {
        List<Product> productsOnSite = productsOnSite();
        OrderedProduct productOrdered = null;
        for (int i = 0; i < productsOnSite.size(); i++) {
            if (product.equals(productsOnSite().get(i))) {
                clickPlusNTimes(quantity, i);
                productOrdered = new OrderedProduct(
                        productsOnSite().get(i).getName(),
                        quantity,
                        productsOnSite().get(i).getPrice(),
                        productsOnSite().get(i).getPrice() * quantity);
            }
        }
        return productOrdered;
    }

//    public OrderedProduct orderProduct(Product product, int quantity) {
//      //DEBUG
//        for (Product p : productsOnSite()) {
//            System.out.println(p.getName());
//        }
//        return productsOnSite().stream()
//                .filter(p -> p.equals(product))
//                .findFirst()
//                .map(p -> {
//                    int index = productsOnSite().indexOf(p);
//                    System.out.println(index);
//                    clickPlusNTimes(quantity, index);
//                    return convertToOrderedProduct(p, quantity);
//                })
//                .orElse(null);
//    } //le kellene kezelni a null-t ha nagyon komolyan vennénk

    private void clickPlusNTimes(int quantity, int index) {
        for (int y = 0; y < quantity; y++) {
            System.out.println("KLIKK");
            waitHelper.click(plusButtons.get(index));
        }
    }

    private OrderedProduct convertToOrderedProduct(Product product, int quantity) {
        return new OrderedProduct(
                product.getName(),
                quantity,
                product.getPrice(),
                product.getPrice() * quantity
        );
    }

    //lehet kell majd a házinál!!!!!!!!!!!!!!!!!!
    public void orderProductByName(String productName) {
        for (int i = 0; i < productTitles.size(); i++) {
            if (productTitles.get(i).getText().equals(productName)) {
                plusButtons.get(i).click();
            }
        }
    }

    public boolean isPracticeUserLoggedIn() {
        return waitHelper.waitForElementPresent(cartButton);
    }

}
//kódtemető


//Refaktor

//    public void fillSearchField(String searchPhrase) {
//        searchProductsInput.sendKeys(searchPhrase);
//    }