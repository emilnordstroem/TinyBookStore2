package application.models.order;

import application.controller.processingServices.OrderProcessingService;
import application.models.customer.CustomerIdentification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderId = 100_001;
    private final int id;
    private final List<OrderLine> orderLines;
    private final LocalDate placementDate;
    private OrderStatus status;
    private final CustomerIdentification customer;
    private final Payment payment;

    public Order(List<OrderLine> orderLines, OrderStatus status, CustomerIdentification customer) {
        orderId += 1;
        this.id = orderId;
        this.orderLines = orderLines;
        this.placementDate = LocalDate.now();
        this.status = status;
        this.customer = customer;
        this.payment = createOrderPayment();
    }

    public static int getOrderId() {
        return orderId;
    }

    public int getId() {
        return id;
    }

    public List<OrderLine> getOrderLines() {
        return new ArrayList<>(orderLines);
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
