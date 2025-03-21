package application.models.stockManagement.quantityTest;

import application.models.stockManagement.Quantity;
import org.junit.jupiter.api.*;

import java.util.IllegalFormatException;

import static org.junit.jupiter.api.Assertions.*;

class QuantityAvailableQuantityTest {
    private Quantity quantity;

    @BeforeEach
    void constructQuantity(){
        quantity = new Quantity(100);
    }

    @Test
    void getAvailableQuantity() {
        int actualResult = quantity.getAvailableQuantity(50);
        assertEquals(50, actualResult);
    }

    @Test
    void getAvailableQuantityLowerEdgeCase() {
        int actualResult = quantity.getAvailableQuantity(0);
        assertEquals(0, actualResult);
    }

    @Test
    void getAvailableQuantityIllegalFormat() {
        assertThrows(NumberFormatException.class, () -> quantity.getAvailableQuantity(-1));
    }

    @Test
    void getAvailableQuantityUpperEdgeCase() {
        int actualResult = quantity.getAvailableQuantity(100);
        assertEquals(100, actualResult);
    }

    @Test
    void getAvailableQuantityAboveUpperEdgeCase() {
        int actualResult = quantity.getAvailableQuantity(101);
        assertEquals(100, actualResult);
    }

}