package application.models.user.cartItem;

import application.models.book.ISBN;
import application.models.user.CartItem;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CartItemUpdateQuantityTest {
    private CartItem cartItem;

    @BeforeEach
    void constructCartItem(){
        cartItem = new CartItem(new ISBN("1234567891123"), 5);
    }

    @Test
    void updateQuantityAdditionNoException() {
        cartItem.updateQuantity(1);
        int actualResult = cartItem.getQuantity();
        assertEquals(6, actualResult);
    }

    @Test
    void updateQuantitySubtractNoException() {
        cartItem.updateQuantity(-2);
        int actualResult = cartItem.getQuantity();
        assertEquals(3, actualResult);
    }

    @Test
    void updateQuantityLowerEdgeCase() {
        cartItem.updateQuantity(-4);
        int actualResult = cartItem.getQuantity();
        assertEquals(1, actualResult);
    }

    @Test
    void updateQuantityUpperEdgeCase() {
        cartItem.updateQuantity(94);
        int actualResult = cartItem.getQuantity();
        assertEquals(99, actualResult);
    }

    @Test
    void updateQuantityLowerIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> cartItem.updateQuantity(95));
    }

    @Test
    void updateQuantityUpperIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> cartItem.updateQuantity(-5));
    }

}