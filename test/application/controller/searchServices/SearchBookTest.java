package application.controller.searchServices;

import application.models.book.*;
import application.models.pricing.Price;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchBookTest {
    private static final List<Book> searchableItems = new ArrayList<>();

    @BeforeAll
    static void constructTestData(){
        for(int bookNo = 1; bookNo <= 10; bookNo++){
            searchableItems.add(new Book(
                new ISBN("1234567891123"),
                new Description(
                        String.format("Book%d", bookNo),
                        Description.Type.HARDCOVER,
                        Description.Genre.NONFICTION,
                        "0",
                        Description.Language.DANISH,
                        Year.now()),
                new Entities(String.format("Author%d", bookNo), "Test"),
                new Dimensions(0, 0, 0),
                new Price(0)
            ));
        }
    }

    @Test
    void searchBookTitleTest(){
        SearchBook searchBook = new SearchBook("Book1");
        searchBook.setSearchableItems(searchableItems);
        searchBook.executeSearch();

        int actualResult = searchBook.getSearchResults().size();
        assertEquals(1, actualResult);
    }

    @Test
    void searchBookAuthorTest(){
        SearchBook searchBook = new SearchBook("Author2");
        searchBook.setSearchableItems(searchableItems);
        searchBook.executeSearch();

        int actualResult = searchBook.getSearchResults().size();
        assertEquals(1, actualResult);
    }

    @Test
    void searchBookPublisherTest(){
        SearchBook searchBook = new SearchBook("Test");
        searchBook.setSearchableItems(searchableItems);
        searchBook.executeSearch();

        int actualResult = searchBook.getSearchResults().size();
        assertEquals(10, actualResult);
    }

}