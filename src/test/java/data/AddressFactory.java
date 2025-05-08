package data;

import com.github.javafaker.Faker;
import michaelclement.eu.data.Address;
import michaelclement.eu.data.Country;

import java.util.Locale;

public class AddressFactory {
    private static final Faker faker = new Faker(Locale.US);
    public static Address getRandrom() {
        return new Address(
                faker.address().streetAddress(),
                faker.address().streetAddressNumber(),
                faker.address().city(),
                Country.randomCountry(),
                faker.address().zipCode()
        );
    }
}
