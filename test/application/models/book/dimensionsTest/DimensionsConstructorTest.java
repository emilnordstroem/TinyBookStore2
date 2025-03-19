package application.models.book.dimensionsTest;

import application.models.book.Dimensions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DimensionsConstructorTest {

    @Test
    void constructObject(){
        Dimensions dimensions = new Dimensions(0,0,0);
        assertNotNull(dimensions);
    }

    @Test
    void constructObjectIllegalArgument(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Dimensions dimensions = new Dimensions(-1, -0.9, 0);
        });
    }

}