package application.models.book.descriptionTest;

import application.models.book.Description;
import org.junit.jupiter.api.*;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionConstructorTest {

    @Test
    void DescriptionCreatedNoException(){
        Description description = new Description(
                "Title",
                Description.Type.HARDCOVER,
                Description.Genre.NONFICTION,
                "300",
                Description.Language.ENGLISH,
                Year.now()
        );
        assertNotNull(description);
    }

    @Test
    void DescriptionCreatedMissingTitle(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Description description = new Description(
                    "",
                    Description.Type.HARDCOVER,
                    Description.Genre.NONFICTION,
                    "300",
                    Description.Language.ENGLISH,
                    Year.now()
            );
        });
        assertEquals("missing title", exception.getMessage());
    }

    @Test
    void DescriptionCreatedNullPointerException(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Description description = new Description(
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
                    "Title",
                    Description.Type.HARDCOVER,
                    Description.Genre.NONFICTION,
                    "-1",
                    Description.Language.ENGLISH,
                    Year.now()
            );
        });
        assertEquals("negative value of pages", exception.getMessage());
    }

    @Test
    void DescriptionCreatedDecimalPages(){
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Description description = new Description(
                    "Title",
                    Description.Type.HARDCOVER,
                    Description.Genre.NONFICTION,
                    "30.5",
                    Description.Language.ENGLISH,
                    Year.now()
            );
        });
    }

    @Test
    void DescriptionCreatedTooManyPages(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Description description = new Description(
                    "Title",
                    Description.Type.HARDCOVER,
                    Description.Genre.NONFICTION,
                    "12345",
                    Description.Language.ENGLISH,
                    Year.now()
            );
        });
        assertEquals("pages > 4 digits", exception.getMessage());
    }

}

