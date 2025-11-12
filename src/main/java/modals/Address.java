package modals;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    // Constructor
    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Getters
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }

    @Override
    public String toString() {

        String cityStr = (city == null || city.isEmpty()) ? "[N/A]" : city;

        return "    - " + street + ", " + cityStr + ", " + state + " " + zip;
    }
}