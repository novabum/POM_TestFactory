package org.example.data;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Order {

    private final List<OrderedProducts> orderedProducts;
    private final OrderingUser orderingUser;

    public Order(List<OrderedProducts> orderedProducts, OrderingUser orderingUser) {
        this.orderedProducts = List.copyOf(orderedProducts);
        this.orderingUser = orderingUser;
    }

    public List<OrderedProducts> getOrderedProducts() {
        return orderedProducts;
    }

    public OrderingUser getOrderingUser() {
        return orderingUser;
    }

    //todo Erre kell unitTestet írni!!! KELL! nincs kivétel
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return compareOrderedProductsList(((Order) o).getOrderedProducts()) && Objects.equals(orderingUser, order.orderingUser);
    }

    private boolean compareOrderedProductsList(List<OrderedProducts> that){
        if (that.size() != this.orderedProducts.size()) return false;
        return  (Set.copyOf(that).equals(Set.copyOf(this.orderedProducts)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderedProducts, orderingUser);
    }
}
