package application.models.order;

import application.models.customer.CustomerIdentification;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private static int orderId = 100_001;
    private List<OrderLine> orderLines;
    private LocalDate placementDate;
    private OrderStatus status;
    private CustomerIdentification customer;
    private Payment payment;

    public Order(List<OrderLine> orderLines, OrderStatus status, CustomerIdentification customer) {
        this.orderLines = orderLines;
        this.placementDate = LocalDate.now();
        this.status = status;
        this.customer = customer;
        this.payment = createOrderPayment();
    }

    private Payment createOrderPayment(){

    }

    private double calculateTotalPrice(){

    }

    private void finalizeOrder(OrderProcessingService processor){

    }

}
