package application.models.book.entitiesTest;

import application.models.book.Entities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntitiesSearchableTest {
    private Entities entities;

    @BeforeEach
    void constructEntities(){
        entities = new Entities("Author", "Publisher");
    }

    @Test
    void matchedAuthor() {
        String searchWord = "AUTHOR";
        boolean actualResult = entities.matched(searchWord);
        assertTrue(actualResult);
    }

    @Test
    void matchedPublisher() {
        String searchWord = "PUBLISHER";
        boolean actualResult = entities.matched(searchWord);
        assertTrue(actualResult);
    }
}