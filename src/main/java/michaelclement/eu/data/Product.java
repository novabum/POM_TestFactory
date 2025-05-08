package michaelclement.eu.data;

import java.util.Objects;

public final class Product {
    private final String name;
    private final String description;
    private final Double price;

    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //copy constructor
    public Product(Product that){
        this.name = that.name;
        this.description = that.description;
        this.price = that.price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }
}
