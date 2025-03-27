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
import storage.BookStorage;
import storage.CustomerStorage;
import storage.DescriptionStorage;
import storage.OrderStorage;

import java.time.Year;
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
        Order order = customer.createOrder(new OrderPlacementService());
        OrderStorage.addOrder(order);
        for(OrderLine orderLine : order.getOrderLines()){
            OrderStorage.addOrderLine(order.getId(), orderLine);
        }
        return order;
    }

    public static Description createDescription(String title, BookType type, BookGenre genre, String pageNo, BookLanguage language, Year publication){
        return new Description(0, title, type, genre, pageNo, language, publication);
    }

    public static Book createBook(Stock stock, ISBN isbn, Description description, Entities entities, Dimensions dimensions, Price price){
        if(description.getId() == 0){
            DescriptionStorage.addDescription(description);
            description = DescriptionStorage.retrieveLastDescription();
        }
        Book book = new Book(isbn, description, entities, dimensions, price);
        BookStorage.addBook(book, stock);
        return book;
    }

}
