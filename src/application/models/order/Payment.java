package application.models.order;

public class Payment {
    private double amount;
    private PaymentStatus status;

    public Payment(double amount) {
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    // should include operations of changing status

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
