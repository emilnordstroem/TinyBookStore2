package application.models.user.shoppingCart;

import application.models.book.ISBN;
import application.models.user.CartItem;
import application.models.user.ShoppingCart;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartResetTest {

    @Test
    void resetShippingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new CartItem(new ISBN("1234567891123"), 2));
        shoppingCart.resetShippingCart();

        int actualResult = shoppingCart.getCartItems().size();
        assertEquals(0, actualResult);
    }
}