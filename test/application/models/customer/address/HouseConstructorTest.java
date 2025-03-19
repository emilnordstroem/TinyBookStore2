package application.models.customer.address;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class HouseConstructorTest {

    @Test
    void ConstructorNoExceptions(){
        House house = new House(
                "Example",
                "12Test",
                8000,
                "Aarhus",
                "Denmark",
                ""
        );
        assertNotNull(house);
    }

    @Test
    void ConstructorNullPointer(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            House house = new House(
                    null,
                    null,
                    8000,
                    null,
                    null,
                    null
            );
        });
    }

    @Test
    void ConstructorIllegalArgument(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            House house = new House(
                    "",
                    "",
                    0,
                    "",
                    "",
                    ""
            );
        });
    }

}