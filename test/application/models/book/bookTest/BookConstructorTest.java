package application.models.book.bookTest;

import application.models.book.*;
import application.models.pricing.Price;
import org.junit.jupiter.api.*;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class BookConstructorTest {

    @Test
    void bookCreatedNoException(){
        Book book = new Book(
                new ISBN("xxxxxxxxxxxxx"),
                new Description(
                        "Test",
                        Description.Type.HARDCOVER,
                        Description.Genre.NONFICTION,
                        "0",
                        Description.Language.DANISH,
                        Year.now()),
                new Entities("Test", "Test"),
                new Dimensions(0, 0, 0),
                new Price(0)
        );
        assertNotNull(book);
    }

    @Test
    void bookNullPointerException(){
        Exception nullPointerException = assertThrows(NullPointerException.class, () -> {
            Book book = new Book(null, null, null, null, null);
        });
    }
}
