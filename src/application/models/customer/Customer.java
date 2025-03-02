package application.models.customer;

import application.models.customer.address.Address;
import application.models.order.Order;
import application.models.user.User;

import java.util.List;

public class Customer extends User {
    private final CustomerIdentification identification;
    private final CustomerDetails details;
    private List<Address> addresses;
    private final List<Order> orders;

    public Customer(CustomerDetails details, Address address, List<Order> orders) {
        this.identification = new CustomerIdentification();
        this.details = details;
        setAddresses(address);
        this.orders = orders;
    }

    public void createOrder(OrderPlacementService processor){

    }

    public int getIdentification() {
        return identification.getCustomerId();
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
