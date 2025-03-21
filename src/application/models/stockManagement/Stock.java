package application.models.stockManagement;

import application.models.book.ISBN;

public class Stock {
    private final ISBN isbn;
    private final Quantity quantity;

    public Stock(ISBN isbn, int quantity) {
        if(isbn == null){
            throw new NullPointerException("isbn is null");
        } else if (quantity < 0) {
            throw new IllegalArgumentException("quantity cannot be less than 0");
        }
        this.isbn = isbn;
        this.quantity = createQuantity(quantity);
    }

    public Quantity createQuantity (int quantity) {
        return new Quantity(quantity);
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
