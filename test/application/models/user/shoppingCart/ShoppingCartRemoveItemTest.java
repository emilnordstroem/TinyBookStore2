package application.models.user.shoppingCart;

import application.models.book.ISBN;
import application.models.user.CartItem;
import application.models.user.ShoppingCart;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartRemoveItemTest {
    private ShoppingCart shoppingCart;
    private CartItem cartItem = new CartItem(new ISBN("1234567891123"), 2);

    @BeforeEach
    void constructShippingCart(){
        shoppingCart = new ShoppingCart();
        shoppingCart.addItem(cartItem);
    }

    @Test
    void removeItem() {
        shoppingCart.removeItem(cartItem);
        int actualResult = shoppingCart.getCartItems().size();
        assertEquals(0, actualResult);
    }

    @Test
    void removeItemNullPointer() {
        assertThrows(NullPointerException.class, () -> shoppingCart.removeItem(null));
    }

    @Test
    void removeItemIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> shoppingCart.removeItem(new CartItem(new ISBN("3211987654321"), 1)));
    }

}