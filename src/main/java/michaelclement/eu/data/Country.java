package michaelclement.eu.data;

import java.util.Random;

public enum Country {
    HUNGARY("Hungary"),
    SLOVAKIA("Slovakia"),
    AUSTRIA("Austria"),
    CROATIA("Croatia");

    private static final Random RANDOM = new Random();
    private final String value;

    Country(String value) {
        this.value = value;
    }

    public static Country randomCountry() {
        Country[] addressCountries = values();
        return addressCountries[RANDOM.nextInt(addressCountries.length)];
    }

    public String getValue() {
        return value;
    }

    public static Country fromString(String countryName) {
        for (Country country : values()) {
            if (country.value.equalsIgnoreCase(countryName)) {
                return country;
            }
        }
        return null;
    }

}
