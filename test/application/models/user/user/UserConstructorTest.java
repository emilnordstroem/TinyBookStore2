package application.models.user.user;

import application.models.customer.Customer;
import application.models.customer.CustomerDetails;
import application.models.customer.address.Apartment;
import application.models.order.Order;
import application.models.user.Guest;
import application.models.user.User;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class UserConstructorTest {

    @Test
    void userConstructorGuest(){
        User user = new Guest();
        assertInstanceOf(User.class, user);
    }

    @Test
    void userConstructorCustomer(){
        User user = new Customer(new CustomerDetails(
                "Test",
                "Example",
                12345678,
                "test@example.com"
                ),
                new Apartment(
                        "ExampleStreet",
                        "Test123",
                        8000,
                        "Aarhus",
                        "Denmark",
                        5,
                        "10"
                ),
                new ArrayList<Order>()
        );
        assertInstanceOf(User.class, user);
    }


}
