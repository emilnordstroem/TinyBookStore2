package application.models.user;

import application.models.book.ISBN;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private ShoppingCart shoppingCart;


    @BeforeEach
    void createShoppingCart(){
        shoppingCart = new ShoppingCart();
    }

    @Test
    void addItem() {
        CartItem item = shoppingCart.createCartItem(new ISBN("xxxxxxxxxxxxx"), 10);
        shoppingCart.addItem(item);
        int actualResult = shoppingCart.getCartItems().size();
        assertEquals(1, actualResult);
    }

    @Test
    void removeItem() {
        CartItem item = shoppingCart.createCartItem(new ISBN("xxxxxxxxxxxxx"), 10);
        shoppingCart.removeItem(item);
        int actualResult = shoppingCart.getCartItems().size();
        assertEquals(0, actualResult);
    }

    @Test
    void resetShippingCart() {
        CartItem item = shoppingCart.createCartItem(new ISBN("xxxxxxxxxxxxx"), 10);
        shoppingCart.addItem(item);
        shoppingCart.resetShippingCart();
        int actualResult = shoppingCart.getCartItems().size();
        assertEquals(0, actualResult);
    }
}