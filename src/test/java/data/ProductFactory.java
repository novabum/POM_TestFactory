package data;

import com.github.javafaker.Faker;
import michaelclement.eu.data.Product;

import java.util.Locale;

public class ProductFactory {

    private static final Faker FAKER = new Faker(Locale.UK);

    public static Product getRandom() {
        return new Product(
                FAKER.commerce().productName(),
                FAKER.lorem().sentence(),
                Double.parseDouble(FAKER.commerce().price(1.0, 1000.0).replace(",", ".")));
    }
}
