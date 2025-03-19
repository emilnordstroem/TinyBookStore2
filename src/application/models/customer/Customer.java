package application.models.customer;

import application.controller.processingServices.OrderPlacementService;
import application.models.customer.address.Address;
import application.models.order.Order;
import application.models.order.OrderLine;
import application.models.user.User;
import storage.OrderStorage;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private final CustomerIdentification identification;
    private final CustomerDetails details;
    private final List<Address> addresses = new ArrayList<>();
    private final List<Order> orders;

    public Customer(CustomerDetails details, Address address, List<Order> orders) {
        if(details == null || address == null || orders == null){
            throw new NullPointerException("null passed to constructor");
        }
        this.identification = new CustomerIdentification();
        this.details = details;
        setAddresses(address);
        this.orders = orders;
    }

    public Order createOrder(OrderPlacementService processor){
        return processor.placeOrder(this);
    }

    public CustomerIdentification getIdentification() {
        return identification;
    }

    public CustomerDetails getDetails() {
        return details;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setAddresses(Address address) {
        addresses.add(address);
    }
}
