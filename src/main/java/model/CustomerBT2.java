package model;

public class CustomerBT2 {
    int id;
    String firstName, lastName, email, customerRole, dateOfBirth, phoneNumber;
    boolean isActive;

    public CustomerBT2(int id, String firstName, String lastName, String email, String customerRole, String dateOfBirth, String phoneNumber, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.customerRole = customerRole;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerRole(String customerRole) {
        this.customerRole = customerRole;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCustomerRole() {
        return customerRole;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString(){
        return (firstName != null ? firstName : "null") + ','
                + (lastName != null ? lastName : "null")+ ','
                + (email != null ? email : "null")+ ','
                + (customerRole != null ? customerRole : "null")+ ','
                + (dateOfBirth != null ? dateOfBirth : "null")+ ','
                + (phoneNumber != null ? phoneNumber : "null")+ ','
                + (lastName != null ? lastName : "null");
    }

}
