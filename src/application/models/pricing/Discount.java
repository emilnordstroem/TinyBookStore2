package application.models.pricing;

public class Discount implements Discountable {
    private int percentage;
    private double threshold;
    private double discount;

    public Discount(int percentage, double threshold, double discount) {
        this.percentage = percentage;
        this.threshold = threshold;
        this.discount = discount;
    }

    public int getPercentage() {
        return percentage;
    }

    public double getThreshold() {
        return threshold;
    }

    public double getDiscount() {
        return discount;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double discountedPrice(double price) {
        return 0;
    }
}
