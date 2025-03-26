package application.controller.searchServices;

import application.models.book.*;
import application.models.pricing.Price;
import storage.BookStorage;

import java.time.Year;
import java.util.List;

public class SearchBook {
    private List<Book> searchableItems;
    private final String searchWord;
    private List<Book> searchResults;

    public SearchBook(String searchWord) {
        if(searchWord == null){
            throw new NullPointerException("searchWord == null");
        }
        this.searchableItems = BookStorage.retrieveAllBooks();
        this.searchWord = searchWord;
    }

    public void executeSearch(){
        int middle = searchableItems.size() / 2;
        SearchAlgorithm<Book> leftSideSearch = new SearchAlgorithm<>(searchableItems.subList(0, middle), searchWord);
        SearchAlgorithm<Book> rightSideSearch = new SearchAlgorithm<>(searchableItems.subList(middle, searchableItems.size()), searchWord);

        try{
            leftSideSearch.start();
            rightSideSearch.start();
            leftSideSearch.join();
            rightSideSearch.join();
        } catch (InterruptedException e) {
            System.out.println(e.getCause() + " " + e.getMessage());
        }

        TotalMergeAlgorithm<Book> mergeLists = new TotalMergeAlgorithm<>(leftSideSearch.getMatches(), rightSideSearch.getMatches());
        searchResults = mergeLists.getMergedList();
    }

    public List<Book> getSearchResults() {
        return searchResults;
    }

    public List<Book> getMockSearchResults() {
        return List.of(
                new Book(
                        new ISBN("1234567890123"),
                        new Description(
                                1,
                                "MockBook1",
                                BookType.PAPERBACK,
                                BookGenre.NONFICTION,
                                "0",
                                BookLanguage.DANISH,
                                Year.now()),
                        new Entities("Test", "Test"),
                        new Dimensions(0, 0, 0),
                        new Price(149)
                ),
                new Book(
                        new ISBN("3210987654321"),
                        new Description(
                                2,
                                "MockBook2",
                                BookType.HARDCOVER,
                                BookGenre.FICTION,
                                "0",
                                BookLanguage.ENGLISH,
                                Year.now()),
                        new Entities("Test", "Test"),
                        new Dimensions(0, 0, 0),
                        new Price(349)
                )
        );
    }

    public void setSearchableItems(List<Book> searchableItems) {
        this.searchableItems = searchableItems;
    }
}