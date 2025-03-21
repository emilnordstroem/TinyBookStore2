package application.controller.searchServices;

import application.models.book.Book;
import application.models.book.Searchable;
import storage.BookStorage;
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

    public void setSearchableItems(List<Book> searchableItems) {
        this.searchableItems = searchableItems;
    }
}