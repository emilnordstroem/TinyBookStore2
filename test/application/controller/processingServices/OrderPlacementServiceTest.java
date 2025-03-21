package application.controller.processingServices;

import application.models.customer.Customer;
import application.models.customer.CustomerDetails;
import application.models.customer.address.Apartment;
import application.models.order.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderPlacementServiceTest {

    @Test
    void placeOrderConstructor(){
        OrderPlacementService placementService = new OrderPlacementService();
        assertNotNull(placementService);
    }

    @Test
    void placeOrderIllegalArgument() {
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
                new ArrayList<>()
        );

        assertThrows(IllegalArgumentException.class, () -> new OrderPlacementService().placeOrder(customer));
    }

    @Test
    void placeOrderNullPointerException(){
        assertThrows(NullPointerException.class, () -> new OrderPlacementService().placeOrder(null));
    }
}