package michaelclement.eu.data;

import java.util.Objects;

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

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address that = (Address) o;
        return Objects.equals(addressLine1, that.addressLine1)
                && Objects.equals(addressLine2, that.addressLine2)
                && Objects.equals(city, that.city)
                && country == that.country //Equals helyett ==???? ááááááááááááááááááááááááááááááááááááááááááááá
                && Objects.equals(zip, that.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressLine1, addressLine2, city, country, zip);
    }
}
