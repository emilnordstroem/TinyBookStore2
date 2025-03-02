package application.models.user;

public abstract class User {
    private ShoppingCart cart;

    public User() {
        this.cart = createCart();
    }

    public ShoppingCart createCart(){

    }

    public void resetCart(){

    }

    public ShoppingCart getCart() {
        return cart;
    }
}
