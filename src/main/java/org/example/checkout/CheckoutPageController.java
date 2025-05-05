package org.example.checkout;

import org.example.data.Address;
import org.example.data.OrderingUser;
import org.example.di.Dependencies;
import org.example.util.WaitHelper;
import org.openqa.selenium.WebDriver;

public class CheckoutPageController extends CheckoutPageElements {

    private final WaitHelper waitHelper;

    public CheckoutPageController(WebDriver driver) {
        super(driver);
        waitHelper = Dependencies.getWaitHelper(driver);
    }
    public void fillCheckoutForm(OrderingUser orderingUser){
        fillFirstName(orderingUser.getFirstName());
        fillLastName(orderingUser.getLastName());
        fillEmail(orderingUser.getEmail());
        fillAddressInfo(orderingUser.getAddress());
    }

    private void fillAddressInfo(Address address){
        fillAddressLine1(address.getAddressLine1());
        fillAddressLine2(address.getAddressLine2());
        fillCity(address.getCity());
        chooseCountry(address.getCountry());
        fillZipCode(address.getZipCode());
    }

    private void fillZipCode(String zipCode) {waitHelper.fillTextField(zipInput, zipCode);}




}
