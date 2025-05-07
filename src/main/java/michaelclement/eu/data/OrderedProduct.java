package michaelclement.eu.data;

public final class OrderedProduct {
    private final String name;
    private final int quantity;
    private final String price;
    private final String totalPrice;

    public OrderedProduct(String name, int quantity, String price, String totalPrice) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }


    public int getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getName() {
        return name;
    }
}


