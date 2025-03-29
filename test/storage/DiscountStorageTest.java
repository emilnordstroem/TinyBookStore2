package storage;

import application.models.pricing.Discount;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class DiscountStorageTest {

    @Test
    void addDiscount() {
        DiscountStorage.addDiscount(new Discount(0, 50, 250));
    }

    @Test
    void retrieveAllDiscounts() {
        ArrayList<Discount> retrievedDiscounts = DiscountStorage.retrieveAllDiscounts();
        int actualResult = retrievedDiscounts.size();
        assertEquals(1, actualResult);
    }

    @Test
    void retrieveLastAddedDiscount() {
        Discount discount = DiscountStorage.retrieveLastAddedDiscount();
        assertEquals(0, discount.getId());
    }

}