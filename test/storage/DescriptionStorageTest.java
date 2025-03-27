package storage;

import application.models.book.BookGenre;
import application.models.book.BookLanguage;
import application.models.book.BookType;
import application.models.book.Description;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionStorageTest {

    @Test
    void addDescription() {
        Description description = new Description(
                0,
                "Test",
                BookType.HARDCOVER,
                BookGenre.NONFICTION,
                "300",
                BookLanguage.DANISH,
                Year.now());
        DescriptionStorage.addDescription(description);
    }

    @Test
    void retrieveAllDescriptions() {
        ArrayList<Description> descriptions = DescriptionStorage.retrieveAllDescriptions();
        int actualResult = descriptions.size();
        assertEquals(1, actualResult);
    }

    @Test
    void retrieveLastDescription() {
        Description description = DescriptionStorage.retrieveLastDescription();
        assertNotNull(description);
    }
}