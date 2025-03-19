package application.models.pricing.discountTest;

import application.models.pricing.Discount;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DiscountDiscountedPriceTest {
    private Discount discount;

    @BeforeEach
    void createDiscount(){
        discount = new Discount(25, 500);
    }

    @Test
    void discountedPrice() {
        double actualResult = discount.discountedPrice(1000);
        assertEquals(875, actualResult);
    }

    @Test
    void discountedPriceEdgeThreshold() {
        double actualResult = discount.discountedPrice(500);
        assertEquals(500, actualResult);
    }

    @Test
    void discountedPriceBelowEdge() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            double actualResult = discount.discountedPrice(499);
        });
    }

}