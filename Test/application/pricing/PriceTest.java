package application.pricing;

import application.models.pricing.Discount;
import application.models.pricing.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    private Price price;
    private Discount discount;


    @BeforeEach
    void createPrice(){
        price = new Price(1000);
        discount = new Discount(50, 500);
    }

    @Test
    void applyDiscount() {
        price.applyDiscount(discount);
        double actualResult = price.getCurrentPrice();
        assertEquals(750, actualResult);
    }

    @Test
    void removeDiscount() {
        price.applyDiscount(discount);
        price.removeDiscount();
        double actualResult = price.getCurrentPrice();
        assertEquals(1000, actualResult);
    }
}