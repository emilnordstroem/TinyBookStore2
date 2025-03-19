package application.models.book.isbnTest;

import application.models.book.ISBN;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ISBNConstructorTest {

    @Test
    void constructedNoException(){
        ISBN isbn = new ISBN("123-1234-12-1");
        assertNotNull(isbn);
    }

    @Test
    void constructedNullPointer(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            ISBN isbn = new ISBN(null);
        });
    }

    @Test
    void constructedLengthIllegalArgument(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ISBN isbn = new ISBN("123-1234-12-12");
        });
        assertEquals("Length not equal 13", exception.getMessage());
    }

    @Test
    void constructedCharacterIllegalArgument(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ISBN isbn = new ISBN("123-1x34-12-1");
        });
        assertEquals("ISBN contains alphabetic characters", exception.getMessage());
    }

}