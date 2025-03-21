package application.models.stockManagement.quantityTest;

import application.models.stockManagement.Quantity;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class QuantityConstructorTest {

    @Test
    void constructorNoException(){
        Quantity quantity = new Quantity(100);
        assertNotNull(quantity);
    }

    @Test
    void constructorEdgeCase(){
        Quantity quantity = new Quantity(0);
        assertNotNull(quantity);
    }

    @Test
    void constructorIllegalArgument(){
        assertThrows(IllegalArgumentException.class, () -> new Quantity(-1));
    }

}