package michaelclement.eu.pages.product;

import michaelclement.eu.data.OrderedProduct;
import michaelclement.eu.data.Product;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductsPageController extends ProductsPageElements {
    private final Random RANDOM = new Random();

    public ProductsPageController(WebDriver driver) {
        super(driver);
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
     * Megrendelünk egy terméket. A termék közben orderedproduct-á válik, hiszen lesz mennyisége és subtotálja
     */

    public OrderedProduct addNumberOfThisProductToCart(Product product, int quantity) {
//        //DEBUG
//        for (Product p : productsOnSite()) {
//            System.out.println(p.getPrice());
//        }
        return productsOnSite().stream()
                .filter(p -> p.equals(product))
                .findFirst()
                .map(p -> {
                    int index = productsOnSite().indexOf(p);
                    System.out.println(index);
                    clickPlusNTimes(quantity, index);
                    return convertToOrderedProduct(p, quantity);
                })
                .orElse(null);
    }

    public void clickPlusNTimes(int quantity, int index) {
        for (int y = 0; y < quantity; y++) {
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

    //lehet kell majd a házinál!
    public void orderProductByName(String productName) {
        for (int i = 0; i < productTitles.size(); i++) {
            if (productTitles.get(i).getText().equals(productName)) {
                plusButtons.get(i).click();
            }
        }
    }

    public boolean isPracticeUserLoggedIn() {
        return waitHelper.waitForElementPresent(sortByDropdown);
    }

    public void sortBySelect(SortType sortType) {
        List<WebElement> sortByDropdownOptions = Arrays.asList(sortByNameOption, sortByPriceOption);
        waitHelper.click(sortByDropdown);
        waitHelper.chooseDropdownOptionByValue(sortByDropdownOptions, sortType.getValue());
    }

    public boolean arePricesSortedAlphabetically() {
        List<Double> prices = scrapePrices();
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private List<Double> scrapePrices() {
        List<Double> prices = new ArrayList<>();
        for (Product product : productsOnSite()) {
            prices.add(product.getPrice());
        }
        return prices;
    }


    public boolean isSortedAlphabetically() {
        List<String> productNames = scrapeProductNames();
        for (int i = 0; i < productNames.size() - 1; i++) {
            if (productNames.get(i).compareToIgnoreCase(productNames.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private List<String> scrapeProductNames() {
        List<String> productNames = new ArrayList<>();
        for (Product product : productsOnSite()) {
            productNames.add(product.getName());
        }
        return productNames;
    }

    public void clickCartButton() {
        waitHelper.click(cartButton);
    }

    public void addMaxTenRandomProductsToCart() {
        int cycle = RANDOM.nextInt(10) + 1;
        for (int i = 0; i < cycle; i++) {
            int button = RANDOM.nextInt(plusButtons.size());
            waitHelper.click(plusButtons.get(button));
        }
    }

    public void typeInSearchField(String text) {
        waitHelper.fillTextField(searchProductsInput, text);
    }

    public void typeAndEnterPriceMinField(Double testPrice) {
        String price = String.valueOf(testPrice);
        waitHelper.fillTextField(minimumPriceFilterInput, price);
        minimumPriceFilterInput.sendKeys(Keys.ENTER);
    }

    public void typeAndEnterPriceMaxField(Double testPrice) {
        String price = String.valueOf(testPrice);
        waitHelper.fillTextField(maximumPriceFilterInput, price);
        maximumPriceFilterInput.sendKeys(Keys.ENTER);
    }


    public boolean isAnyPriceLowerThan(Double testPrice) {
        List<Double> pricesVisible = getPrices();
        for (Double price : pricesVisible) {
            if (price > testPrice) return false;
        }
        return true;
    }

    private List<Double> getPrices() {
        return productPrices.stream()
                .map(e -> Double.parseDouble(e.getText().substring(8)))
                .toList();
    }

    public void clickEveryAddToCartButton() {
        plusButtons.forEach(waitHelper::click);
    }

    public void clickEveryRemoveFromCartButton() {
        minusButtons.forEach(waitHelper::click);
    }

    public boolean isEveryQuantityEqualsZero() {
        for (WebElement quantity : quantityElements) {
            String value = quantity.getDomProperty("value");
            if (value == null || Integer.parseInt(value) > 0) {
                return false;
            }
        }
        return true;
    }

    public void addRandomProductsToCart(int numberOfProducts) {
        for (int i = 0; i < numberOfProducts; i++) {
            int button = RANDOM.nextInt(plusButtons.size());
            waitHelper.click(plusButtons.get(button));
        }
    }
}

//kódtemető


//Refaktor

//    public void fillSearchField(String searchPhrase) {
//        searchProductsInput.sendKeys(searchPhrase);
//    }


//    public OrderedProduct orderProduct(Product product, int quantity) {
//        List<Product> productsOnSite = productsOnSite();
//        OrderedProduct productOrdered = null;
//        for (int i = 0; i < productsOnSite.size(); i++) {
//            System.out.println(product.getName() + " " + product.getPrice());
//            System.out.println(productsOnSite().get(i).getName() + " " + productsOnSite().get(i).getPrice());
//            System.out.println(product.equals(productsOnSite().get(i)));
//            if (product.equals(productsOnSite().get(i))) {
//                clickPlusNTimes(quantity, i);
//                productOrdered = new OrderedProduct(
//                        productsOnSite().get(i).getName(),
//                        quantity,
//                        productsOnSite().get(i).getPrice(),
//                        productsOnSite().get(i).getPrice() * quantity);
//            }
//        }
//        return productOrdered;
//    }
