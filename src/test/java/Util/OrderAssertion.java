package Util;

import org.assertj.core.api.SoftAssertions;
import michaelclement.eu.data.Order;
import org.junit.jupiter.api.Assertions;

public class OrderAssertion {
    public void assertOrder(Order expected, Order actual){
        try {
            Assertions.assertEquals(expected, actual);
        } catch (Exception e) {
            SoftAssertions softAssertions = new SoftAssertions();
            int productCount = expected.getProducts().size();

            for (int i = 0; i < productCount; i++){
                try {
                    softAssertions.assertThat(actual.getProducts().get(i)).isEqualTo(expected.getProducts().get(i));
                }
                catch (IndexOutOfBoundsException e) {
                    softAssertions.fail(String.format("The %dth product is missing from the cart", i+1));
                }
            }

            softAssertions.assertThat(actual.getOrderingUser().getFirstName()).isEqualTo(expected.getOrderingUser().getFirstName());

            softAssertions.assertAll();

        }
    }
}
