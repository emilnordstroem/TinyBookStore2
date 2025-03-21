package application.controller.searchServices;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchBookConstructorTest {

    @Test
    void constructorNoException(){
        SearchBook searchBook = new SearchBook("Test");
        assertNotNull(searchBook);
    }

    @Test
    void constructorNullPointer(){
        assertThrows(NullPointerException.class, () -> new SearchBook(null));
    }

}
