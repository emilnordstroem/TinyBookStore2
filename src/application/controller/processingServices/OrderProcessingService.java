package application.controller.processingServices;

import application.models.order.Order;
import application.models.order.OrderStatus;

public class OrderProcessingService {

    public Order processOrder(Order order){
        //TODO
        // possible when storage is implemented
        return order;
    }

    public OrderStatus processOrderStatus(Order order, OrderStatus orderStatus){
        //TODO
        return order.getStatus();
    }

}
