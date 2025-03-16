package application.models.stockManagement;

public class Quantity {
    private static int threshold = 10;
    private int quantity;
    private QuantityStatus quantityStatus;

    public Quantity(int quantity) {
        this.quantity = quantity;
        updateQuantityStatus();
    }

    public static int getThreshold() {
        return threshold;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAvailableQuantity(int requestedQuantity){
        return Math.min(requestedQuantity, quantity);
    }

    public QuantityStatus getQuantityStatus() {
        return quantityStatus;
    }

    public void updateQuantity(int quantity) {
        this.quantity += quantity;
        updateQuantityStatus();
    }

    private void updateQuantityStatus(){
        int availableQuantity = quantity;
        if(availableQuantity > threshold){
            this.quantityStatus = QuantityStatus.HIGHSTOCK;
        } else if (availableQuantity < threshold) {
            this.quantityStatus = QuantityStatus.LOWSTOCK;
            lowStockAlert();
        } else if (availableQuantity == 0) {
            this.quantityStatus = QuantityStatus.OUTOFSTOCK;
        }
    }

    public static void setThreshold(int threshold) {
        Quantity.threshold = threshold;
    }

    private void lowStockAlert(){
        System.out.println("CONCERN: LOW STOCK");
    }
}
