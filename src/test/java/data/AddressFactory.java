package data;

import com.github.javafaker.Faker;
import org.example.data.Address;
import org.example.data.Country;

import java.util.Locale;

public class AddressFactory {
    public static final Faker faker = new Faker(Locale.US);
    public static Address getRandrom() {
        return new Address(
                faker.address().streetAddress(),
                faker.address().secondaryAddress(),
                faker.address().city(),
                Country.randomCountry(),
                faker.address().zipCode()
        );
    }
}
