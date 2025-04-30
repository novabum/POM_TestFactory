package org.example.data;

public final class Product {
    private final String name;
    private final String desctription;
    private final String price;

    public Product(String name, String desctription, String price) {
        this.name = name;
        this.desctription = desctription;
        this.price = price;
    }

    //copy constructor
    public Product(Product that){
        this.name = that.name;
        this.desctription = that.desctription;
        this.price = that.price;
    }
}
