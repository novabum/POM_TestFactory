package data;

import com.github.javafaker.Faker;
import michaelclement.eu.data.OrderingUser;

import java.util.Locale;

public class OrderingUserFactory {
    private static final Faker FAKER = new Faker(Locale.US);

    public static OrderingUser getRandom(){
        return new OrderingUser(
                FAKER.name().firstName(),
                FAKER.name().lastName(),
                FAKER.internet().emailAddress(),
                AddressFactory.getRandrom()
        );
    }
}
