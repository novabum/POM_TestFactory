package michaelclement.eu.data;

import java.util.Objects;

public final class OrderingUser {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final Address address;

    public OrderingUser(String firstname, String lastname, String email, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderingUser that = (OrderingUser) o;
        return Objects.equals(firstname, that.firstname)
                && Objects.equals(lastname, that.lastname)
                && Objects.equals(email, that.email)
                && Objects.equals(address, that.address); // Címnél is javítani az equalst
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, email, address);
    }
}
