package application.models.stockManagement;

public class Quantity {
    private static int threshold = 10;
    private int quantity;
    private QuantityStatus quantityStatus;

    public Quantity(int quantity, QuantityStatus quantityStatus) {
        this.quantity = quantity;
        this.quantityStatus = quantityStatus;
    }

    public static int getThreshold() {
        return threshold;
    }

    public int getQuantity() {
        return quantity;
    }

    public QuantityStatus getQuantityStatus() {
        return quantityStatus;
    }

    public void updateQuantity(int quantity){

    }

    private void updateQuantityStatus(){

    }

    public void lowStockAlert(){

    }
}
