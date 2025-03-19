package application.controller.sortingServices;

import application.models.book.Book;
import application.models.pricing.Price;

import java.util.ArrayList;
import java.util.List;

public class HighToLowSort {

    public static List<Book> highestToLowestPriceSort(List<Book> unsortedBooks, int low, int high){
        if(low < high){
            int indexOfPivotElement = partition(unsortedBooks, low, high);
            highestToLowestPriceSort(unsortedBooks, low, indexOfPivotElement - 1);
            highestToLowestPriceSort(unsortedBooks, indexOfPivotElement + 1, high);
        }
        return new ArrayList<>(unsortedBooks);
    }

    public static int partition (List<Book> unsortedList, int low, int high) {
        Book pivotElement = unsortedList.get(low);
        int indexLow = low + 1;
        int indexHigh = high;

        while(indexLow <= indexHigh){
            Book lowElement = unsortedList.get(indexLow);
            if(lowElement.compareToCurrentPrice(pivotElement) >= 0){
                indexLow++;
            } else if (lowElement.compareToCurrentPrice(pivotElement) < 0) {
                indexHigh--;
            } else {
                swap(unsortedList, indexLow, indexHigh);
                indexLow++;
                indexHigh--;
            }
        }
        swap(unsortedList, low, indexHigh);
        return indexHigh;
    }

    public static void swap(List<Book> unsortedList, int indexLow, int indexHigh){
        Book temp = unsortedList.get(indexLow);
        unsortedList.set(indexLow, unsortedList.get(indexHigh));
        unsortedList.set(indexHigh, temp);
    }

}
