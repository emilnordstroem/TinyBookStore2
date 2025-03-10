package application.controller.processingServices;

import application.models.customer.Customer;
import application.models.order.Order;
import application.models.order.OrderLine;
import application.models.order.OrderStatus;
import application.models.user.CartItem;

import java.util.ArrayList;

public class OrderPlacementService {

    public static Order placeOrder(Customer customer){
        ArrayList<CartItem> shoppingCartItem = new ArrayList<>(customer.getCart().getCartItems());
        ArrayList<OrderLine> orderLines = new ArrayList<>();

        for(CartItem item : shoppingCartItem){
            orderLines.add(new OrderLine(item.getIsbn(), item.getQuantity()));
        }

        return new Order(orderLines, OrderStatus.PLACED, customer.getIdentification());
    }

}
