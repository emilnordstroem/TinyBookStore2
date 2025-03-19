package application.models.book.bookTest;

import application.models.book.*;
import application.models.pricing.Price;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Year;

class BookSearchableTest {
    private Book book;

    @BeforeEach
    void constructBook(){
        book = new Book(
            new ISBN("xxxxxxxxxxxxx"),
            new Description(
                    "Title",
                    Description.Type.HARDCOVER,
                    Description.Genre.NONFICTION,
                    "0",
                    Description.Language.DANISH,
                    Year.now()),
            new Entities("Author", "Publisher"),
            new Dimensions(0, 0, 0),
            new Price(0)
        );
    }

    @Test
    void matchedTitleAllUppercase() {
        String searchString = "TITLE";
        boolean actualResult = book.matched(searchString);
        assertTrue(actualResult);
    }

    @Test
    void matchedAuthorAllUpperCase() {
        String searchString = "AUTHOR";
        boolean actualResult = book.matched(searchString);
        assertTrue(actualResult);
    }

    @Test
    void matchedPublisherAllUppercase() {
        String searchString = "PUBLISHER";
        boolean actualResult = book.matched(searchString);
        assertTrue(actualResult);
    }

}