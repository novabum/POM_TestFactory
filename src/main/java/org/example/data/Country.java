package org.example.data;

import java.util.Random;

public enum Country {
    HUNGARY("Hungary"),
    SLOVAKIA("Slovakia"),
    AUSTRIA("Austria"),
    CROATIA("Croatia");

    private static final Random RANDOM = new Random();
    private final String value;

    Country(String value) {this.value = value;};

    public static Country randomCountry (){
        Country[] addresscountries = values();
        return addresscountries[RANDOM.nextInt(addresscountries.length)];
    }
    public String getValue() {return value;}
}
