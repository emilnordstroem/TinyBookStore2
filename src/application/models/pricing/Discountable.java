package application.models.pricing;

@FunctionalInterface
public interface Discountable {
    double discountedPrice(double price);
}
