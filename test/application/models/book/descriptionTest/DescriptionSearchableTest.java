package application.models.book.descriptionTest;

import application.models.book.BookGenre;
import application.models.book.BookLanguage;
import application.models.book.BookType;
import application.models.book.Description;
import org.junit.jupiter.api.*;

import java.time.Year;
import static org.junit.jupiter.api.Assertions.*;

class DescriptionSearchableTest {
    private Description description;

    @BeforeEach
    void createDescriptionObject(){
        description = new Description(
                0,
            "Title",
            BookType.HARDCOVER,
            BookGenre.NONFICTION,
            "300",
            BookLanguage.ENGLISH,
            Year.now()
        );
    }

    @Test
    void matchedToUpperCase() {
        String searchKeyword = "TITLE";
        boolean actualResult = description.matched(searchKeyword);
        assertTrue(actualResult);
    }
}