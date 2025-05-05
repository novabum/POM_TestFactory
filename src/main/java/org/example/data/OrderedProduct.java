package org.example.data;

public final class OrderedProduct {
    private final String title;
    private final int quantity;
    private final double price;
    private final double totalPrice;

    public OrderedProduct(String title, int quantity, double price, double totalPrice) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }
}
