package application.controller.sortServices;

import application.controller.searchServices.SearchBook;
import application.models.book.*;
import application.models.pricing.Price;
import org.junit.jupiter.api.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortSearchTest {
    private static ArrayList<Book> unsortedBookList = new ArrayList<>();

    @BeforeAll
    static void constructTestData(){
        String[] bookTitles = {"To Kill a Mockingbird", "1984", "The Great Gatsby", "Moby-Dick", "Pride and Prejudice"};
        double[] bookPrices = {49.95, 245.95, 120, 89.95, 99.95};

        for(int bookNo = 0; bookNo < 5; bookNo++){
            unsortedBookList.add(
                new Book(
                        new ISBN("1234567891123"),
                        new Description(
                                bookTitles[bookNo],
                                Description.Type.HARDCOVER,
                                Description.Genre.NONFICTION,
                                "0",
                                Description.Language.DANISH,
                                Year.of(new Random().nextInt(1980, 2025))),
                        new Entities("Test", "Test"),
                        new Dimensions(0, 0, 0),
                        new Price(bookPrices[bookNo])
                )
            );
        }
    }

    @Test
    void lowestToHighestPriceTest(){
        SortSearch sortSearch = new SortSearch(unsortedBookList, SortSpecification.LOWTOHIGH);
        sortSearch.sortBookBySpecification();
        ArrayList<Book> actualResult = sortSearch.getSortedBookList();

        for (int bookIndex = 0; bookIndex < actualResult.size() - 1; bookIndex++) {
            double currentBookPrice = actualResult.get(bookIndex).getPrice().getCurrentPrice();
            double nextBookPrice = actualResult.get(bookIndex + 1).getPrice().getCurrentPrice();
            assertTrue(currentBookPrice <= nextBookPrice,
                    "List is not sorted correctly: " + actualResult.get(bookIndex).getPrice() + " > " + actualResult.get(bookIndex + 1).getPrice());
        }
    }

    @Test
    void highestToLowestPriceTest(){
        SortSearch sortSearch = new SortSearch(unsortedBookList, SortSpecification.HIGHTOLOW);
        sortSearch.sortBookBySpecification();
        ArrayList<Book> actualResult = sortSearch.getSortedBookList();

        for (int bookIndex = 0; bookIndex < actualResult.size() - 1; bookIndex++) {
            double currentBookPrice = actualResult.get(bookIndex).getPrice().getCurrentPrice();
            double nextBookPrice = actualResult.get(bookIndex + 1).getPrice().getCurrentPrice();
            assertTrue(currentBookPrice >= nextBookPrice,
                    "List is not sorted correctly: " + actualResult.get(bookIndex).getPrice() + " < " + actualResult.get(bookIndex + 1).getPrice());
        }
    }

    @Test
    void newestArrivalsTest(){
        SortSearch sortSearch = new SortSearch(unsortedBookList, SortSpecification.NEWESTARRIVALS);
        sortSearch.sortBookBySpecification();
        ArrayList<Book> actualResult = sortSearch.getSortedBookList();

        for (int bookIndex = 0; bookIndex < actualResult.size() - 1; bookIndex++) {
            Year currentBookYear = actualResult.get(bookIndex).getDescription().getPublicationYear();
            Year nextBookYear = actualResult.get(bookIndex + 1).getDescription().getPublicationYear();
            assertTrue(currentBookYear.isBefore(nextBookYear),
                    "List is not sorted correctly: " + actualResult.get(bookIndex).getDescription().getPublicationYear() + " > " + actualResult.get(bookIndex + 1).getDescription().getPublicationYear());
        }
    }

}