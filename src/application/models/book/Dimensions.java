package application.models.book;

public class Dimensions {
    private double height;
    private double width;
    private double weight;

    public Dimensions(double height, double width, double weight) {
        this.height = height;
        this.width = width;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getWeight() {
        return weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
