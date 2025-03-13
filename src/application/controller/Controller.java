package application.controller;

import application.controller.processingServices.OrderPlacementService;
import application.models.book.*;
import application.models.customer.Customer;
import application.models.customer.CustomerDetails;
import application.models.customer.address.Address;
import application.models.order.Order;
import application.models.order.OrderLine;
import application.models.order.OrderStatus;
import application.models.pricing.Price;
import storage.BookStorage;
import storage.CustomerStorage;
import storage.OrderStorage;

import java.util.ArrayList;
import java.util.List;

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

    public static Book createBook(ISBN isbn, Description description, Entities entities, Dimensions dimensions, Price price){
        Book book = new Book(isbn, description, entities, dimensions, price);
        BookStorage.addBook(book);
        return book;
    }

}
