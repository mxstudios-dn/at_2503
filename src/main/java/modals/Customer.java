package modals;

import java.util.List;
public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String dateOfBirth;
    private String customerRole;
    private boolean isActive;

    private String address; // random add from CSV

    public Customer() {}

    public Customer(String customerId, String firstName, String lastName,
                    String email, String phone, String dateOfBirth,
                    String customerRole, boolean isActive) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.customerRole = customerRole;
        this.isActive = isActive;
    }

    // GETTERS
    public String getCustomerId() { return customerId; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getEmail() { return email; }

    public String getPhone() { return phone; }

    public String getDateOfBirth() { return dateOfBirth; }

    public String getCustomerRole() { return customerRole; }

    public boolean isActive() { return isActive; }

    public String getAddress() { return address; }

    @Override
    public String toString() {
        return customerId + " | " + firstName + " | " + lastName + " | " + email
                + " | " + phone + " | " + dateOfBirth + " | " + customerRole
                + " | " + isActive + " | ADDRESS: " + address;
    }

}









