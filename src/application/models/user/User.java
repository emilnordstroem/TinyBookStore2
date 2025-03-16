package application.models.user;

public abstract class User {
    private final ShoppingCart cart;

    public User() {
        this.cart = createCart();
    }

    public ShoppingCart createCart(){
        return new ShoppingCart();
    }

    public void resetCart(){
        cart.resetShippingCart();
    }

    public ShoppingCart getCart() {
        return cart;
    }
}
