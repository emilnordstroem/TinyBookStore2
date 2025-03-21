package application.models.user.cartItem;

import application.models.book.ISBN;
import application.models.user.CartItem;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CartItemConstructorTest {

    @Test
    void constructorNoException(){
        CartItem cartItem = new CartItem(new ISBN("1234567891123"), 2);
        assertNotNull(cartItem);
    }

    @Test
    void constructorEdgeCaseNoException(){
        CartItem cartItem = new CartItem(new ISBN("1234567891123"), 1);
        assertNotNull(cartItem);
    }

    @Test
    void constructorIllegalArgument(){
        assertThrows(IllegalArgumentException.class, () -> new CartItem(new ISBN("1234567891123"), 0));
    }

    @Test
    void constructorNullPointer(){
        assertThrows(NullPointerException.class, () -> new CartItem(null, 1));
    }

}