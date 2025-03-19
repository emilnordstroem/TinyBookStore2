package application.models.pricing.discountTest;

import application.models.pricing.Discount;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DiscountConstructorTest {

    @Test
    void constructorNoException(){
        Discount discount = new Discount(25, 0);
        assertNotNull(discount);
    }

    @Test
    void constructorNoDifferenceIllegalArgument(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Discount discount = new Discount(0, 500);
        });
        assertEquals("No difference if implemented", exception.getMessage());
    }

    @Test
    void constructorPercentageIllegalArgument(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Discount discount = new Discount(101, 0);
        });
        assertEquals("Percentage is under 0 or over 100", exception.getMessage());
    }

    @Test
    void constructorNegativValueIllegalArgument(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Discount discount = new Discount(-1, 500);
        });
        assertEquals("Percentage is under 0 or over 100", exception.getMessage());
    }

}