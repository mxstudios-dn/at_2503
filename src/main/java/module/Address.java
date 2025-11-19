package module;

public class Address {
    private int no;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String timeZone;
    private String county;
    private String addressName;

    public Address(int no, String address, String city, String state,
                   String zip, String timeZone, String county, String addressName) {
        this.no = no;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.timeZone = timeZone;
        this.county = county;
        this.addressName = addressName;
    }

    public int getNo() { return no; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }
    public String getTimeZone() { return timeZone; }
    public String getCounty() { return county; }
    public String getAddressName() { return addressName; }

    @Override
    public String toString() {
        return no + ": " + address + ", " + city + ", " + state + " " + zip;
    }
}
