package application.models.user;

import application.models.book.ISBN;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> cartItems;

    public ShoppingCart() {
    }

    public CartItem createCartItem(ISBN isbn, int quantity){
        return new CartItem(isbn, quantity);
    }

    public void addItem(CartItem item){

    }

    public void removeItem(CartItem item){

    }

    public double calculatePrice(){
        return 0;
    }

    public List<CartItem> getCartItems() {
        return new ArrayList<>();
    }
}
