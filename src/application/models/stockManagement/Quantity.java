package application.models.stockManagement;

public class Quantity {
    private static int threshold = 50;
    private int quantity;
    private QuantityStatus quantityStatus;

    public Quantity(int quantity) {
        if(quantity < 0){
            throw new IllegalArgumentException("quantity cannot be less than 0");
        }
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
        if(requestedQuantity < 0){
            throw new NumberFormatException("requestedQuantity cannot be less than 0");
        }
        return Math.min(requestedQuantity, quantity);
    }

    public QuantityStatus getQuantityStatus() {
        return quantityStatus;
    }

    public void updateQuantity(int quantity) {
        if((this.quantity + quantity) < 0){
            throw new IllegalArgumentException("quantity passed will result in negative quantity");
        }
        this.quantity += quantity;
        updateQuantityStatus();
    }

    private void updateQuantityStatus(){
        int availableQuantity = quantity;
        if(availableQuantity > threshold){
            this.quantityStatus = QuantityStatus.HIGHSTOCK;
        } else if (availableQuantity > 0 && availableQuantity < threshold) {
            this.quantityStatus = QuantityStatus.LOWSTOCK;
            lowStockAlert();
        } else if (availableQuantity == 0) {
            this.quantityStatus = QuantityStatus.OUTOFSTOCK;
            zeroStockAlert();
        }
    }

    public static void setThreshold(int threshold) {
        Quantity.threshold = threshold;
    }

    private void lowStockAlert(){
        System.out.println("CONCERN: LOW STOCK");
    }

    private void zeroStockAlert(){
        System.out.println("CONCERN: OUT OF STOCK");
    }
}
