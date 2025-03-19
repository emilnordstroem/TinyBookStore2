package application.models.pricing;

public class Price implements Comparable<Price> {
    private double originalPrice;
    private double discountedPrice;
    private Discount discount;

    public Price(double originalPrice) {
        if(originalPrice < 0){
            throw new IllegalArgumentException("OriginalPrice cannot be under 0");
        }
        this.originalPrice = originalPrice;
    }

    public double getCurrentPrice(){
        if(discount != null){
            return discountedPrice;
        }
        return originalPrice;
    }

    public void applyDiscount(Discount discount){
        if(discount == null){
            throw new NullPointerException();
        } else if(this.discount != null){
            removeDiscount();
        }
        this.discount = discount;
        discountedPrice = discount.discountedPrice(originalPrice);
    }

    public void removeDiscount(){
        discount = null;
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

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    @Override
    public int compareTo(Price otherPrice) {
        return (int) getCurrentPrice() - (int) otherPrice.getCurrentPrice();
    }
}
