package modals;

public class AddressModal {
//    No,Address,City,State,Zip,TimeZone,County,Address Name,
    /**
     * Address Modal Class
     */
    private int no;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String timeZone;
    private String county;
    private String addressName;

    public AddressModal(int no, String address, String city, String state, String zip, String timeZone, String county) {
        this.no = no;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.timeZone = timeZone;
        this.county = county;
        this.addressName = address + ", " + city + ", " + state + " " + zip;
    }

}
