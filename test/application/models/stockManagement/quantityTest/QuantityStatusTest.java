package application.models.stockManagement.quantityTest;

import application.models.stockManagement.Quantity;
import application.models.stockManagement.QuantityStatus;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityStatusTest {
    private Quantity quantity;

    @BeforeEach
    void constructQuantity(){
        quantity = new Quantity(100);
    }

    @Test
    void quantityStatusHighStock(){
        QuantityStatus actualResult = quantity.getQuantityStatus();
        assertEquals(QuantityStatus.HIGHSTOCK, actualResult);
    }

    @Test
    void quantityStatusEdgeHighStock(){
        quantity.updateQuantity(-50);
        QuantityStatus actualResult = quantity.getQuantityStatus();
        assertEquals(QuantityStatus.HIGHSTOCK, actualResult);
    }

    @Test
    void quantityStatusLowStock(){
        quantity.updateQuantity(-51);
        QuantityStatus actualResult = quantity.getQuantityStatus();
        assertEquals(QuantityStatus.LOWSTOCK, actualResult);
    }

    @Test
    void quantityStatusEdgeLowStock(){
        quantity.updateQuantity(-99);
        QuantityStatus actualResult = quantity.getQuantityStatus();
        assertEquals(QuantityStatus.LOWSTOCK, actualResult);
    }

    @Test
    void quantityStatusOutOfStock(){
        quantity.updateQuantity(-100);
        QuantityStatus actualResult = quantity.getQuantityStatus();
        assertEquals(QuantityStatus.OUTOFSTOCK, actualResult);
    }

}
