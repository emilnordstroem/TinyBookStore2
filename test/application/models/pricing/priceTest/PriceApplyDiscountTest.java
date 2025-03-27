package application.models.pricing.priceTest;

import application.models.pricing.Discount;
import application.models.pricing.Price;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PriceApplyDiscountTest {
    private Price price;

    @BeforeEach
    void setupPrice(){
        price = new Price(1000);
    }

    @Test
    void applyDiscountWithDiscountNoException() {
        Discount discount = new Discount(0,20, 0);
        price.applyDiscount(discount);
        Discount newDiscount = new Discount(0,50, 0);
        price.applyDiscount(newDiscount);
        double actualResult = price.getDiscount().getPercentage();
        assertEquals(50, actualResult);
    }

    @Test
    void applyDiscountNoDiscountNoException() {
        Discount discount = new Discount(0,20, 0);
        price.applyDiscount(discount);
        assertNotNull(price.getDiscount());
    }

    @Test
    void applyDiscountNullPointer() {
        assertThrows(NullPointerException.class, () -> {
            price.applyDiscount(null);
        });
    }

}