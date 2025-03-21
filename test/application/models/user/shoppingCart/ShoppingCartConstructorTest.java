package application.models.user.shoppingCart;

import application.models.user.ShoppingCart;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartConstructorTest {

    @Test
    void constructShoppingCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        assertNotNull(shoppingCart);
    }

}