package org.example.data;

public final class OrderedProducts {
    private final String title;
    private final int quantity;
    private final double price;
    private final double totalPrice;

    public OrderedProducts(String title, int quantity, double price) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = quantity*price;
    }
}
