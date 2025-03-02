package application.models.customer;

public class CustomerIdentification {
    private static int id = 100_000;
    private final int customerId;

    public CustomerIdentification() {
        this.customerId = id++;
    }

    public int getCustomerId() {
        return customerId;
    }
}
