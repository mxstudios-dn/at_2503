package modals;
public class AddressDetails {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String timeZone;

    public AddressDetails(String street, String city, String state, String zip, String timeZone) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + zip + " (" + timeZone + ")";
    }
}