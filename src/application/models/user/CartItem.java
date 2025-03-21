package application.models.user;

import application.models.book.ISBN;

public class CartItem {
    private final ISBN isbn;
    private int quantity;

    public CartItem(ISBN isbn, int quantity) {
        if(isbn == null){
            throw new NullPointerException("isbn == null");
        } else if (quantity < 1) {
            throw new IllegalArgumentException("quantity is less than 1");
        }
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int quantity) {
        if((this.quantity + quantity) < 1 || (this.quantity + quantity > 99)){
            throw new IllegalArgumentException("Quantity must be above 0 and below 100");
        }
        this.quantity += quantity;
    }
}
