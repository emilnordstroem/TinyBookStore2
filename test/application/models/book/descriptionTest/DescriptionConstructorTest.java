package application.models.book.descriptionTest;

import application.models.book.BookGenre;
import application.models.book.BookLanguage;
import application.models.book.BookType;
import application.models.book.Description;
import org.junit.jupiter.api.*;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionConstructorTest {

    @Test
    void DescriptionCreatedNoException(){
        Description description = new Description(
                1,
                "Title",
                BookType.HARDCOVER,
                BookGenre.NONFICTION,
                "300",
                BookLanguage.ENGLISH,
                Year.now()
        );
        assertNotNull(description);
    }

    @Test
    void DescriptionCreatedMissingTitle(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Description description = new Description(
                    0,
                    "",
                    BookType.HARDCOVER,
                    BookGenre.NONFICTION,
                    "300",
                    BookLanguage.ENGLISH,
                    Year.now()
            );
        });
        assertEquals("missing title", exception.getMessage());
    }

    @Test
    void DescriptionCreatedNullPointerException(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Description description = new Description(
                    0,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            );
        });
    }

    @Test
    void DescriptionCreatedNegativePages(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Description description = new Description(
                    0,
                    "Title",
                    BookType.HARDCOVER,
                    BookGenre.NONFICTION,
                    "-1",
                    BookLanguage.ENGLISH,
                    Year.now()
            );
        });
        assertEquals("negative value of pages", exception.getMessage());
    }

    @Test
    void DescriptionCreatedDecimalPages(){
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Description description = new Description(
                    0,
                    "Title",
                    BookType.HARDCOVER,
                    BookGenre.NONFICTION,
                    "30.5",
                    BookLanguage.ENGLISH,
                    Year.now()
            );
        });
    }

    @Test
    void DescriptionCreatedTooManyPages(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Description description = new Description(
                    0,
                    "Title",
                    BookType.HARDCOVER,
                    BookGenre.NONFICTION,
                    "12345",
                    BookLanguage.ENGLISH,
                    Year.now()
            );
        });
        assertEquals("pages > 4 digits", exception.getMessage());
    }

}

