package application.models.pricing;

public class Price {
    private double originalPrice;
    private double discountedPrice;
    private Discount discount;

    public Price(double originalPrice, Discount discount) {
        this.originalPrice = originalPrice;
        this.discountedPrice = discountedPrice;
        this.discount = discount;
    }

    private double getCurrentPrice(){

    }

    private void applyDiscount(){

    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public Discount getDiscount() {
        return discount;
    }
}
