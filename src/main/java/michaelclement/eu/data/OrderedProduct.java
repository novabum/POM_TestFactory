package michaelclement.eu.data;

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
}


