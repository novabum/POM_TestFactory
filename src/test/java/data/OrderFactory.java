package data;

import michaelclement.eu.data.Order;
import michaelclement.eu.data.OrderedProduct;
import michaelclement.eu.data.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderFactory {
//    private static final Random RANDOM = new Random();
//    private static final List<OrderedProduct> initialList = new ArrayList<>();
//    private static final List<OrderedProduct> adminProductList = new ArrayList<>();
//
//    public static Order getRandom(int productCount) {
//        return getRandomMinAdmin(productCount, 0);
//    }
//
//    public static void AddAdminProducts(List<Product> products) {
//        for (Product product : products) {
//            adminProductList.add(new OrderedProduct(
//                    product.getName(),
//                    0,
//                    "$" + product.getPrice(),
//                    null
//            ));
//        }
//    }
//
//    private static Order getRandomMinAdmin(int productCount, int i) {
//        uploadInitialList();
//        List<OrderedProduct> orderedProductList = new ArrayList<>();
//    for (int i = 0; i < minAdminProductCount; i++){
//        orderedProductList.add(getRandomProduct(adminProductList));
//    }
//    for (int i = 0; i < fullProductCount-minAdminProductCount; i++){
//        orderedProductList.add(getRandomProduct(initialList));
//    }
//
//    return new Order(
//            OrderingUserFactory.getRandom(),
//orderedProductList
////            OrderingUserFactory.getRandom(),
////            orderedProductList
//    );
//
//    }
//
//    private static void uploadInitialList(){
//        initialList.clear();
//        initialList.add(new OrderedProduct(
//                "Michael's Mug",
//                0,
//                "$10",
//                null
//        ));
//        initialList.add(new OrderedProduct(
//                "Michael's Cap",
//                0,
//                "$10",
//                null
//        ));
//        initialList.add(new OrderedProduct(
//                "Michael's Notebook",
//                0,
//                "$10",
//                null
//        ));
//        initialList.add(new OrderedProduct(
//                "Michael's T-shirt",
//                0,
//                "$10",
//                null
//        ));
//
//    }
//
//    public static OrderedProduct getRandomProduct(List<OrderedProduct> productList){
//        int index = RANDOM.nextInt(productList.size());
//        OrderedProduct product = productList.get(index);
//        int quantity = RANDOM.nextInt(11);
//        int price = Integer.parseInt(product.getPrice().substring(1));
//        int totalPrice = price * quantity;
//        String totalPriceString = "$" + totalPrice;
//        productList.remove(index);
//        return new OrderedProduct(product.getName(), quantity, product.getPrice(), totalPriceString);
//    }

}
