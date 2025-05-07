package michaelclement.eu.pages.product;

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

    public void fillSearchField(String searchPhrase) {
        searchProductsInput.sendKeys(searchPhrase);
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
        return getProductsFromSite().get(index);
    }

    private List<Product> getProductsFromSite() {
        List<Product> productsOnSite = new ArrayList<>();
        for (int i = 0; i < productTitles.size(); i++) {
            String name = productTitles.get(i).getText();
            String desc = productDescriptions.get(i).getText();
            Double price = Double.parseDouble(productPrices.get(i).getText().substring(8));
            productsOnSite.add(new Product(name, desc, price));
        }
        return productsOnSite;
    }

    public void orderProduct(Product product, int quantity) {
        List<Product> productsOnSite = getProductsFromSite();
        for (int i = 0; i < productsOnSite.size(); i++) {
            if (product.equals(getProductsFromSite().get(i))) {
                clickPlusNTimes(quantity, i);
            }
        }
    }

    private void clickPlusNTimes(int quantity, int i) {
        for (int y = 0; y < quantity; y++) {
            waitHelper.click(plusButtons.get(i));
        }
    }

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
