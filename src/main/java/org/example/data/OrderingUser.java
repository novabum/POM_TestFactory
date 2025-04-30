package org.example.data;

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
}
