package application.models.customer;

import application.models.customer.address.Apartment;
import application.models.order.Order;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerIdentificationConstructorTest {

    @Test
    void correctIdentificationNo(){
        ArrayList<Integer> customerIds = new ArrayList<>();
        for(int iteration = 0; iteration <= 5; iteration++){
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
            customerIds.add(customer.getIdentification().getCustomerId());
        }
        int actualResult = customerIds.getLast();
        assertEquals(100005, actualResult);
    }

}