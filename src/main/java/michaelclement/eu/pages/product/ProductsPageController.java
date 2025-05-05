package michaelclement.eu.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPageController extends ProductsPageElements {


    public ProductsPageController(WebDriver driver) {
        super(driver);
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
}
