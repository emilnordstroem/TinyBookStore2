package application.controller;

import application.controller.processingServices.OrderPlacementService;
import application.models.customer.Customer;
import application.models.customer.CustomerDetails;
import application.models.customer.address.Address;
import application.models.order.Order;
import application.models.order.OrderLine;
import storage.CustomerStorage;
import storage.OrderStorage;

import java.util.ArrayList;

public class Controller {

    public static Customer createCustomer(String firstName, String lastName, int phoneNo, String email, Address address){
        CustomerDetails details = new CustomerDetails(firstName, lastName, phoneNo, email);
        Customer customer = new Customer(details, address, new ArrayList<>());
        CustomerStorage.addCustomer(customer);
        return customer;
    }

    public static void removeCustomer(Customer customer){
        CustomerStorage.removeCustomer(customer);
    }

    public static Order createOrder(Customer customer){
        Order order = OrderPlacementService.placeOrder(customer);
        OrderStorage.addOrder(order);
        for(OrderLine orderLine : order.getOrderLines()){
            OrderStorage.addOrderLine(order.getId(), orderLine);
        }
        return order;
    }

}
