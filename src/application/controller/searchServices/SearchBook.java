package application.controller.searchServices;

import application.models.book.Searchable;
import java.util.ArrayList;
import java.util.List;

public class SearchBook <T extends Searchable<String> & Comparable<T>> {
    private final List<T> searchableItems;
    private final String searchWord;
    private List<T> searchResults;

    public SearchBook(String searchWord) {
        this.searchableItems = new ArrayList<>(); // Must retrieve items from storage
        this.searchWord = searchWord;
        executeSearch();
    }

    private void executeSearch(){
        int middle = searchableItems.size() / 2;
        SearchAlgorithm<T> leftSideSearch = new SearchAlgorithm<T>(searchableItems.subList(0, middle), searchWord);
        SearchAlgorithm<T> rightSideSearch = new SearchAlgorithm<T>(searchableItems.subList(middle, searchableItems.size()), searchWord);

        try{
            leftSideSearch.start();
            rightSideSearch.start();
            leftSideSearch.join();
            rightSideSearch.join();
        } catch (InterruptedException e) {
            System.out.println(e.getCause() + " " + e.getMessage());
        }

        TotalMergeAlgorithm<T> mergeLists = new TotalMergeAlgorithm<>(leftSideSearch.getMatches(), rightSideSearch.getMatches());
        searchResults = mergeLists.getMergedList();
    }

    public List<T> getSearchResults() {
        return searchResults;
    }
}