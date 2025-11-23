package model;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return state; }

    @Override
    public String toString() {
        return (street != null ? street : "[no street]") + ", " +
                (city != null ? city : "[no city]") + ", " +
                (state != null ? state : "[no state]") + " " +
                (zip != null ? zip : "[no zip]");
    }
}

