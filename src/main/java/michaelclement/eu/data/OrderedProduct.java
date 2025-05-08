package michaelclement.eu.data;

import java.util.Objects;

public final class OrderedProduct {
    private final String name;
    private final Integer quantity;
    private final Double price;
    private final Double totalPrice;

    public OrderedProduct(String name, Integer quantity, Double price, Double totalPrice) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderedProduct product = (OrderedProduct) o;
        return Objects.equals(name, product.name) && Objects.equals(quantity, product.quantity) && Objects.equals(price, product.price) && Objects.equals(totalPrice, product.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, price, totalPrice);
    }
}


