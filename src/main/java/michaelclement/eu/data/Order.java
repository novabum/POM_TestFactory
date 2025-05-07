package michaelclement.eu.data;

import java.util.*;

public class Order {

    private final List<OrderedProduct> orderedProducts;
    private final OrderingUser orderingUser;

    public Order(List<OrderedProduct> orderedProducts, OrderingUser orderingUser) {
        this.orderedProducts = List.copyOf(orderedProducts);
        this.orderingUser = orderingUser;
    }

//    private List<OrderedProduct> copyProductList(List<OrderedProduct> products){
//        List<OrderedProduct> copy = new ArrayList<>();
//        for (OrderedProduct product: products){
//            copy.add(product);
//        }
//        return copy;
//    }

    public List<OrderedProduct> getOrderedProducts() {
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

    private boolean compareOrderedProductsList(List<OrderedProduct> that) {
        if (that.size() != this.orderedProducts.size()) return false;
        return (Set.copyOf(that).equals(Set.copyOf(this.orderedProducts)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderedProducts, orderingUser);
    }

    public Map<Object, Object> getProducts() {
    return null;}



}
