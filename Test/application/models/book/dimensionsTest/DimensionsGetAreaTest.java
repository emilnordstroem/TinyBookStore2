package application.models.book.dimensionsTest;

import application.models.book.Dimensions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DimensionsGetAreaTest {

    @Test
    void getArea() {
        Dimensions dimensions = new Dimensions(22,12.5,200);
        double actualResult = dimensions.getArea();
        assertEquals(275, actualResult);
    }

}