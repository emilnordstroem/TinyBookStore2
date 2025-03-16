package application.models.stockManagement;

import application.models.book.ISBN;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {
    Stock stock;

    @BeforeEach
    void setupStock(){
        stock = new Stock(new ISBN("xxxxxxxxxxxxx"), 100);
    }

    @Test
    void getAvailableQuantityPass() {
        int actualResult = stock.getQuantity().getAvailableQuantity(10);
        assertEquals(10, actualResult);
    }

    @Test
    void getAvailableQuantityEdge() {
        int actualResult = stock.getQuantity().getAvailableQuantity(100);
        assertEquals(100, actualResult);
    }

    @Test
    void getAvailableQuantityFail() {
        int actualResult = stock.getQuantity().getAvailableQuantity(101);
        assertEquals(100, actualResult);
    }

}