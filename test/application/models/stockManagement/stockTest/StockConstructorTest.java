package application.models.stockManagement.stockTest;

import application.models.book.ISBN;
import application.models.stockManagement.Quantity;
import application.models.stockManagement.Stock;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class StockConstructorTest {

    @Test
    void constructor(){
        Stock stock = new Stock(new ISBN("1234567891123"), 100);
        assertNotNull(stock);
    }

    @Test
    void constructorEdgeCase(){
        Stock stock = new Stock(new ISBN("1234567891123"), 0);
        assertNotNull(stock);
    }

    @Test
    void constructorCreatesQuantity(){
        Stock stock = new Stock(new ISBN("1234567891123"), 100);
        Quantity quantity = stock.getQuantity();
        assertNotNull(quantity);
    }

    @Test
    void constructorNullPointer(){
        assertThrows(NullPointerException.class, () -> new Stock(null, 100));
    }

    @Test
    void constructorIllegalArgument(){
        assertThrows(IllegalArgumentException.class, () -> new Stock(new ISBN("1234567891123"), -1));
    }

}