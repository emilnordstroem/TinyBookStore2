package application.controller.controller;

import application.controller.processingServices.OrderPlacementService;
import application.models.book.*;
import application.models.customer.Customer;
import application.models.customer.CustomerDetails;
import application.models.customer.address.Address;
import application.models.order.Order;
import application.models.order.OrderLine;
import application.models.pricing.Price;
import application.models.stockManagement.Stock;
import storage.*;

import java.time.Year;
import java.util.ArrayList;

public class Controller {
    BookStorage bookStorage;
    CustomerStorage customerStorage;
    DescriptionStorage descriptionStorage;
    DiscountStorage discountStorage;
    OrderStorage orderStorage;

    public Controller() {
        bookStorage = new BookStorage();
        customerStorage = new CustomerStorage();
        descriptionStorage = new DescriptionStorage();
        discountStorage = new DiscountStorage();
        orderStorage = new OrderStorage();
    }

    public Customer createCustomer(String firstName, String lastName, int phoneNo, String email, Address address){
        CustomerDetails details = new CustomerDetails(firstName, lastName, phoneNo, email);
        Customer customer = new Customer(details, address, new ArrayList<>());
        customerStorage.addCustomer(customer);
        return customer;
    }

    public void removeCustomer(Customer customer){
        customerStorage.removeCustomer(customer);
    }

    public Order createOrder(Customer customer){
        Order order = customer.createOrder(new OrderPlacementService());
        orderStorage.addOrder(order);
        for(OrderLine orderLine : order.getOrderLines()){
            orderStorage.addOrderLine(order.getId(), orderLine);
        }
        return order;
    }

    public Description createDescription(String title, BookType type, BookGenre genre, String pageNo, BookLanguage language, Year publication){
        return new Description(0, title, type, genre, pageNo, language, publication);
    }

    public Book createBook(Stock stock, ISBN isbn, Description description, Entities entities, Dimensions dimensions, Price price){
        if(description.getId() == 0){
            descriptionStorage.addDescription(description);
            description = descriptionStorage.retrieveLastDescription();
        }
        Book book = new Book(isbn, description, entities, dimensions, price);
        bookStorage.addBook(book, stock);
        return book;
    }

}
