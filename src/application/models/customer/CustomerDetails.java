package application.models.customer;

public class CustomerDetails {
    private final String firstName;
    private final String lastName;
    private final int phoneNo;
    private final String email;

    public CustomerDetails(String firstName, String lastName, int phoneNo, String email) {
        if(firstName == null || lastName == null || email == null){
            throw new NullPointerException("null passed to constructor");
        } else if (firstName.isBlank() || lastName.isBlank() || String.valueOf(phoneNo).length() != 8) {
            throw new IllegalArgumentException("incorrect data or mission input field");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }
}
