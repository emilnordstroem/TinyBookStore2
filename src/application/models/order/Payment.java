package application.models.order;

public class Payment {
    private double amount;
    private PaymentStatus status;

    public Payment(double amount) {
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void updatePaymentStatus(PaymentStatus status){
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
