package application.models.order;

import application.models.book.ISBN;

public class OrderLine {
    private final ISBN orderedBook;
    private final int orderedQuantity;

    public OrderLine(ISBN orderedBook, int orderedQuantity) {
        this.orderedBook = orderedBook;
        this.orderedQuantity = orderedQuantity;
    }

    private double getOrderLinePrice(){

    }

    public ISBN getOrderedBook() {
        return orderedBook;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

}
