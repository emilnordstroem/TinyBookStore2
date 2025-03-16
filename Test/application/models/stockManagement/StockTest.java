package application.models.stockManagement;

import application.models.book.ISBN;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @Test
    void createStock(){
        Stock stock = new Stock(new ISBN("xxxxxxxxxxxxx"), 1000);
        int actualResult = stock.getQuantity().getQuantity();
        assertEquals(1000, actualResult);
    }
}