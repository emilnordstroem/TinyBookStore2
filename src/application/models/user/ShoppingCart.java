package application.models.user;

import application.models.book.ISBN;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> cartItems = new ArrayList<>();

    public ShoppingCart() {
    }

    public CartItem createCartItem(ISBN isbn, int quantity){
        return new CartItem(isbn, quantity);
    }

    public void addItem(CartItem item){
        for(CartItem currentItem : cartItems){
            if(currentItem.getIsbn() == item.getIsbn()){
                currentItem.updateQuantity(item.getQuantity());
                break;
            }
        }
        cartItems.add(item);
    }

    public void removeItem(CartItem item){
        cartItems.remove(item);
    }

    // possible when storage is implemented
    public double calculatePrice(){
        return 0;
    }

    public List<CartItem> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    public void resetShippingCart(){
        this.cartItems = new ArrayList<>();
    }
}
