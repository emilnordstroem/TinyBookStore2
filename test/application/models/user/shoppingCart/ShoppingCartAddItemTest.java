package application.models.user.shoppingCart;

import application.models.book.ISBN;
import application.models.user.CartItem;
import application.models.user.ShoppingCart;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartAddItemTest {
    private ShoppingCart shoppingCart;

    @BeforeEach
    void constructShippingCart(){
        shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new CartItem(new ISBN("1234567891123"), 2));
    }

    @Test
    void addItemNotAlreadyInCart() {
        shoppingCart.addItem(new CartItem(new ISBN("3211987654321"), 1));
        int actualResult = shoppingCart.getCartItems().size();
        assertEquals(2, actualResult);
    }

    @Test
    void addItemAlreadyInCart() {
        shoppingCart.addItem(new CartItem(new ISBN("1234567891123"), 1));
        int actualResult = shoppingCart.getCartItems().size();
        assertEquals(1, actualResult);
    }

    @Test
    void addItemAlreadyInCartUpdate() {
        shoppingCart.addItem(new CartItem(new ISBN("1234567891123"), 1));
        int actualResult = shoppingCart.getCartItems().getFirst().getQuantity();
        assertEquals(3, actualResult);
    }

}