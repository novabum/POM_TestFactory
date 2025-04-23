package org.example.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPageElements {
    @FindBy (xpath = "//td[@data-test-id='table-product-name']")
    protected List<WebElement> productNames;

    @FindBy (xpath = "//input[@class='quantity-input']")
    protected List<WebElement> quantities;

    @FindBy (xpath = "//td[@data-test-id='table-price']")
    protected List<WebElement> prices;

    @FindBy (xpath = "//td[@data-test-id='table-total-price']")
    protected List<WebElement> totalPrices;

    @FindBy (xpath = "//td[@data-test-id='cart-total-price']")
    protected WebElement cartTotalPrice;

    @FindBy (xpath = "//a[@class='table-left-button']")
    protected WebElement backToProductsButton;

    @FindBy (xpath = "//button[@class='table-right-button']")
    protected WebElement checkoutButton;

  public void CartPageElements(WebDriver driver){
      PageFactory.initElements(driver, this);
  }

}
