package application.models.pricing;

public class Discount implements Discountable {
    private int percentage;
    private double threshold;

    public Discount(int percentage, double threshold) {
        this.percentage = percentage;
        this.threshold = threshold;
    }

    public int getPercentage() {
        return percentage;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public double discountedPrice(double price) {
        return (price - ((price - threshold) * percentage) / 100);
    }
}
