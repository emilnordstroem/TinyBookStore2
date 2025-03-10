package application.controller.searching;

import application.models.book.*;
import application.models.pricing.Price;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchBookTest {
    private static List<Book> searchableList = new ArrayList<>();

    @BeforeAll
    static void createSearchCondition(){
        searchableList = new ArrayList<>(List.of(
            new Book(
                    new ISBN("xxx_xxx_xxx"),
                    new Description("Example1", "345", Year.now()),
                    new Entities("author", "publisher"),
                    new Dimensions(19, 10, 20),
                    new Price(125)
            ),
            new Book(
                    new ISBN("xxx_xxx_xxx"),
                    new Description("Example", "345", Year.now()),
                    new Entities("author2", "publisher"),
                    new Dimensions(19, 10, 20),
                    new Price(125)
            ),
            new Book(
                    new ISBN("xxx_xxx_xxx"),
                    new Description("Example", "345", Year.now()),
                    new Entities("author", "publisher3"),
                    new Dimensions(19, 10, 20),
                    new Price(125)
            )
        ));

    }

    @Test
    void getSearchResults() {
        SearchBook<Book> searchBook = new SearchBook<>("Publisher", searchableList);
        int actualResult = searchBook.getSearchResults().size();
        assertEquals(2, actualResult);
    }

    @AfterAll
    static void resetSearch(){
        searchableList = new ArrayList<>();
    }
}