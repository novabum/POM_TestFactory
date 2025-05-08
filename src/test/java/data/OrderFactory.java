package data;

import michaelclement.eu.data.OrderedProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderFactory {
    private static final Random RANDOM = new Random();
    private static final List<OrderedProduct> initialList = new ArrayList<>();
    private static final List<OrderedProduct> adminProductList = new ArrayList<>();

            //ez már megrendelt termékre vonatkozik
//    public static OrderedProduct chooseRandomOrderedProduct(List<OrderedProduct> orderedProducts) {
//        int index = RANDOM.nextInt(orderedProducts.size()); //random szám max listaméretig (0-től, mert index)
//        OrderedProduct product = orderedProducts.get(index); //Maga a termék a random szám
//        int quantity = RANDOM.nextInt(11); //mennyiség
//        int price = Integer.parseInt(product.getPrice().substring(1));
//        int totalPrice = price * quantity;
//        String totalPriceString = "$" + totalPrice;
//        orderedProducts.remove(index);
//        return new OrderedProduct(product.getName(), quantity, product.getPrice(), totalPriceString);
//    }

}