package application.models.stockManagement.quantityTest;

import application.models.stockManagement.Quantity;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class QuantityUpdateQuantityTest {
    private Quantity quantity;

    @BeforeEach
    void constructQuantity(){
        quantity = new Quantity(100);
    }

    @Test
    void updateQuantityAddition() {
        quantity.updateQuantity(50);
        int actualResult = quantity.getQuantity();
        assertEquals(150, actualResult);
    }

    @Test
    void updateQuantitySubtract() {
        quantity.updateQuantity(-50);
        int actualResult = quantity.getQuantity();
        assertEquals(50, actualResult);
    }

    @Test
    void updateQuantitySubtractEdgeCase() {
        quantity.updateQuantity(-100);
        int actualResult = quantity.getQuantity();
        assertEquals(0, actualResult);
    }

    @Test
    void updateQuantityException() {
        assertThrows(IllegalArgumentException.class, () -> quantity.updateQuantity(-101));
    }

}