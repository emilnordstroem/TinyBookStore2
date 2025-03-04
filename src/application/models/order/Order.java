package application.models.order;

import application.controller.processingServices.OrderProcessingService;
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

    public static int getOrderId() {
        return orderId;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public LocalDate getPlacementDate() {
        return placementDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public CustomerIdentification getCustomer() {
        return customer;
    }

    public Payment getPayment() {
        return payment;
    }

    private Payment createOrderPayment(){
        return new Payment(0);
    }

    private double calculateTotalPrice(){
        return 0;
    }

    private void finalizeOrder(OrderProcessingService processor){

    }

}
