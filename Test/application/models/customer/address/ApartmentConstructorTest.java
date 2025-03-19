package application.models.customer.address;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ApartmentConstructorTest {

    @Test
    void ConstructorNoExceptions(){
        Apartment apartment = new Apartment(
                "Example",
                "12Test",
                8000,
                "Aarhus",
                "Denmark",
                5,
                "1"
        );
        assertNotNull(apartment);
    }

    @Test
    void ConstructorNullPointer(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Apartment apartment = new Apartment(
                    null,
                    null,
                    0,
                    null,
                    null,
                    0,
                    null
            );
        });
    }

    @Test
    void ConstructorIllegalArgument(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Apartment apartment = new Apartment(
                    "",
                    "",
                    12345,
                    "",
                    "",
                    -2,
                    ""
            );
        });
    }



}