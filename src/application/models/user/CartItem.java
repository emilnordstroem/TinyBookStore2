package application.models.user;

import application.models.book.ISBN;

public class CartItem {
    private final ISBN isbn;
    private int quantity;

    public CartItem(ISBN isbn, int quantity) {
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
        if((this.quantity + quantity) >= 1){
            this.quantity += quantity;
        }
    }
}
