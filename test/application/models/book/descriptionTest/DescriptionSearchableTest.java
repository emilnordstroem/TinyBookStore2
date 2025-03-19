package application.models.book.descriptionTest;

import application.models.book.Description;
import org.junit.jupiter.api.*;

import java.time.Year;
import static org.junit.jupiter.api.Assertions.*;

class DescriptionSearchableTest {
    private Description description;

    @BeforeEach
    void createDescriptionObject(){
        description = new Description(
            "Title",
            Description.Type.HARDCOVER,
            Description.Genre.NONFICTION,
            "300",
            Description.Language.ENGLISH,
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