package storage;

import application.models.book.*;
import application.models.pricing.Price;
import application.models.stockManagement.Stock;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookStorageTest {

    @Test
    void addBook() {
        Book book = new Book(
                new ISBN("1234567890123"),
                new Description(
                        1,
                        "Test",
                        BookType.HARDCOVER,
                        BookGenre.NONFICTION,
                        "300",
                        BookLanguage.DANISH,
                        Year.now()),
                new Entities("Test", "Test"),
                new Dimensions(0, 0, 0),
                new Price(195.59)
        );
        Stock stock = new Stock(book.getIsbn(), 40);
        BookStorage.addBook(book, stock);
    }

    @Test
    void retrieveAllBooks() {
        ArrayList<Book> books = BookStorage.retrieveAllBooks();
        int actualResult = books.size();
        assertEquals(1, actualResult);
    }

    @Test
    void retrieveAllBookStock() {
        ArrayList<Stock> stocks = BookStorage.retrieveAllBookStock();
        int actualResult = stocks.size();
        assertEquals(1, actualResult);
    }

    @Test
    void retrieveBookStock() {
        Stock stock = BookStorage.retrieveBookStock(new ISBN("1234567890123"));
        assertNotNull(stock);
    }
}