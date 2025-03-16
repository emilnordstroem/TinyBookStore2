package application.controller.processingServices;

import application.models.book.ISBN;
import application.models.customer.Customer;
import application.models.customer.CustomerDetails;
import application.models.customer.address.Address;
import application.models.customer.address.Apartment;
import application.models.order.Order;
import application.models.user.CartItem;
import application.models.user.ShoppingCart;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderPlacementServiceTest {
    private Customer customer;

    @BeforeEach
    void createCustomer(){
        CustomerDetails details = new CustomerDetails("TestCustomer", "TestLastName", 20_02_20_02, "mail@example.com");
        Address address = new Apartment("ExampleStreet", "xx", 9000, "Aalborg", "Denmark", 5, "20");
        this.customer = new Customer(details, address, new ArrayList<>());
        customer.getCart().addItem(new CartItem(new ISBN("xxx_xxx_xxx_xxx"), 1));
    }

    @Test
    void placeOrder() {
        Order order = customer.createOrder(new OrderPlacementService());
        int actualResult = order.getOrderLines().size();
        assertEquals(1, actualResult);
    }
}