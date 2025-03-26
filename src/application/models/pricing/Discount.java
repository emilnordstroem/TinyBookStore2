package application.models.pricing;

public class Discount implements Discountable {
    private final int id;
    private int percentage;
    private double threshold;

    public Discount(int id, int percentage, double threshold) {
        this.id = id;
        if(percentage < 0 || percentage > 100){
            throw new IllegalArgumentException("Percentage is under 0 or over 100");
        } else if (percentage == 0) {
            throw new IllegalArgumentException("No difference if implemented");
        }
        this.percentage = percentage;
        this.threshold = threshold;
    }

    public int getId() {
        return id;
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
        if(price < threshold){
            throw new IllegalArgumentException("price is below threshold");
        }
        return (price - ((price - threshold) * percentage) / 100);
    }
}
