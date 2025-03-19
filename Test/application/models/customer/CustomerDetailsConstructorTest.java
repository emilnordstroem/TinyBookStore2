package application.models.customer;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerDetailsConstructorTest {

    @Test
    void customerDetailsNoException(){
        CustomerDetails customerDetails = new CustomerDetails(
                "Test",
                "Example",
                12345678,
                "test@example.com"
        );
        assertNotNull(customerDetails);
    }

    @Test
    void customerDetailsNullPointer(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            CustomerDetails customerDetails = new CustomerDetails(
                    null,
                    null,
                    12345678,
                    null
            );
        });
    }

    @Test
    void customerDetailsIllegalArgument(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CustomerDetails customerDetails = new CustomerDetails(
                    "",
                    "",
                    0,
                    ""
            );
        });
    }
}