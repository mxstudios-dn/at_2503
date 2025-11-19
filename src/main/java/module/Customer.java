package module;

public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String dateOfBirth;
    private String customerRole;
    private boolean isActive;

    private Address address;

    public Customer(String customerId, String firstName, String lastName, String email,
                    String phone, String dateOfBirth, String customerRole, Boolean isActive){
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.customerRole = customerRole;
        this.isActive = isActive;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public Address getAddress(){
        return address;
    }

    @Override
    public String toString(){
        return "\nCustomerId: " + customerId
                + "\nName: " + firstName + " " + lastName
                +"\nEmail: " + email
                +"\nPhone: " + phone
                +"\nBirthday: " + dateOfBirth
                +"\nCustomer Role: " + customerRole
                +"\nIsActive: " +isActive
                +"\nAddress: " + (address != null? address.toString(): "Null");
    }
}
