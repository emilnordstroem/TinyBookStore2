package application.models.stockManagement;

import application.models.book.ISBN;

public class Stock {
    private final ISBN isbn;
    private Quantity quantity;

    public Stock(ISBN isbn) {
        this.isbn = isbn;
    }

    public Quantity createQuantity (int quantity) {

    }

    public ISBN getIsbn() {
        return isbn;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
