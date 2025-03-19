package application.models.customer;

import application.models.customer.address.Apartment;
import application.models.order.Order;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerConstructorTest {

    @Test
    void constructCustomerNoException(){
        Customer customer = new Customer(
                new CustomerDetails(
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
        assertNotNull(customer);
    }

    @Test
    void customerNullPointerException(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Customer customer = new Customer(null,null, null);
        });
    }

}