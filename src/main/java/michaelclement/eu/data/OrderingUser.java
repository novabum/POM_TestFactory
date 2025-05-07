package michaelclement.eu.data;

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
}
