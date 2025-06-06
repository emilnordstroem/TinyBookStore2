package application.controller.sortServices;

import application.models.book.Book;

import java.util.ArrayList;
import java.util.List;

public class SortSearch {
    private final List<Book> listOfBooks;
    private final SortSpecification specification;
    private List<Book> sortedBookList = new ArrayList<>();

    public SortSearch(List<Book> listOfBooks, SortSpecification specification) {
        if(listOfBooks == null || specification == null){
           throw new NullPointerException("null passed to SortSearch()");
        } else if (listOfBooks.isEmpty()) {
            throw new IllegalArgumentException("listOfBooks cannot be empty");
        }
        this.listOfBooks = listOfBooks;
        this.specification = specification;
    }

    public void sortBookBySpecification(){
        switch (specification) {
            case NEWESTARRIVALS -> sortedBookList = NewestSort.newestBookArrivalsSort(listOfBooks, 0, listOfBooks.size() - 1);
            case LOWTOHIGH -> sortedBookList = LowToHighSort.lowestToHighestPriceSort(listOfBooks, 0, listOfBooks.size() - 1);
            case HIGHTOLOW -> sortedBookList = HighToLowSort.highestToLowestPriceSort(listOfBooks, 0, listOfBooks.size() - 1);
        }
    }

    public ArrayList<Book> getSortedBookList() {
        return new ArrayList<>(sortedBookList);
    }
}
