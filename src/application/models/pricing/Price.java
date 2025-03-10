package application.models.pricing;

public class Price {
    private double originalPrice;
    private double discountedPrice;
    private Discount discount;

    public Price(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getCurrentPrice(){
        if(discount != null){
            return discountedPrice;
        }
        return originalPrice;
    }

    public void applyDiscount(Discount discount){
        if(this.discount != null){
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
}
