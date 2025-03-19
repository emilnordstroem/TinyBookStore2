package application.models.book.entitiesTest;

import application.models.book.Entities;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class EntitiesConstructorTest {

    @Test
    void createEntities(){
        Entities entities = new Entities("Author", "Publisher");
        assertNotNull(entities);
    }

    @Test
    void createEntitiesIllegalArgument(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Entities entities = new Entities("", " ");
        });
    }

    @Test
    void createEntitiesNullPointerException(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Entities entities = new Entities(null, null);
        });
    }



}
