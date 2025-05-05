package michaelclement.eu.data;

public final class Product {
    private final String name;
    private final String description;
    private final Double price;

    public Product(String name, String desctription, Double price) {
        this.name = name;
        this.description = desctription;
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
}
