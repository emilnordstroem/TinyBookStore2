package application.models.pricing.priceTest;

import application.models.pricing.Price;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PriceConstructorTest {

    @Test
    void constructorNoExceptons(){
        Price price = new Price(1000);
        assertNotNull(price);
    }

    @Test
    void constructorEgdeCase(){
        Price price = new Price(0);
        assertNotNull(price);
    }

    @Test
    void constructorException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Price price = new Price(-1);
        });
    }

}