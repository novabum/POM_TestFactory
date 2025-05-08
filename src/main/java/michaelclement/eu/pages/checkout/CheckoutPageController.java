package michaelclement.eu.pages.checkout;

import michaelclement.eu.data.Address;
import michaelclement.eu.data.Country;
import michaelclement.eu.data.OrderingUser;
import michaelclement.eu.util.Dependencies;
import michaelclement.eu.util.WaitHelper;
import org.openqa.selenium.WebDriver;

public class CheckoutPageController extends CheckoutPageElements {

    public CheckoutPageController(WebDriver driver) {
        super(driver);
    }

    public void fillCheckoutForm(OrderingUser orderingUser) {
        fillFirstName(orderingUser.getFirstname());
        fillLastName(orderingUser.getLastname());
        fillEmail(orderingUser.getEmail());
        fillAddressInfo(orderingUser.getAddress());
    }

    private void fillAddressInfo(Address address) {
        fillAddressLine1(address.getAddressLine1());
        fillAddressLine2(address.getAddressLine2());
        fillCity(address.getCity());
        chooseCountry(address.getCountry());
        fillZipCode(address.getZip());
    }

    private void fillZipCode(String zipCode) {
        waitHelper.fillTextField(zipInput, zipCode);
    }

    private void chooseCountry(Country country) {
        waitHelper.click(countryDropDown);
        waitHelper.chooseDropdownOptionByValue(countryDropDownOptions, country.getValue());
    }

    private void fillCity(String city) {
        waitHelper.fillTextField(cityInput, city);
    }

    private void fillAddressLine1(String addressLine1) {
        waitHelper.fillTextField(addressLine1Input, addressLine1);
    }

    private void fillAddressLine2(String addressLine2) {
        waitHelper.fillTextField(addressLine2Input, addressLine2);
    }

    private void fillEmail(String email) {
        waitHelper.fillTextField(emailInput, email);
    }

    private void fillLastName(String lastname) {
        waitHelper.fillTextField(lastnameInput, lastname);
    }

    private void fillFirstName(String firstname) {
        waitHelper.fillTextField(firstnameInput, firstname);
    }

    public void clickSummaryButton() {
        waitHelper.click(summaryButton);
    }


}
