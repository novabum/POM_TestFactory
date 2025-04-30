package org.example.data;

public class Address {
    private final String addressLine1;
    private final String addressLine2;
    private final String city;
    private final Country country;
    private final String zip;

    public Address(String addressLine1, String addressLine2, String city, Country country, String zip) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.country = country;
        this.zip = zip;
    }
}
