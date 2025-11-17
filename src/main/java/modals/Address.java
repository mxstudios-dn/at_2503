package modals;

public class Address {
    private int no;
    private String address;
    private String city;
    private String state;
    private String timezone;
    private String zip;
    private String country;
    private String name;

    public Address(int no, String address, String city, String state, String zip, String timezone , String country,  String name){
        this.no = no;
        this.address = address;
        this.city = city;
        this.name = name;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.timezone = timezone;
    }

    public String getCity(){
        return city;
    }
    public String getAddress(){
        return address;
    }
    public String getName(){
        return name;
    }
    public String getState(){
        return state;
    }
    public String getZip(){
        return zip;
    }
    public String getCountry(){
        return country;
    }
    public int getNo(){
        return no;
    }
    public String getTimezone(){
        return timezone;
    }
    @Override
    public String toString(){
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s",
                no, address, city, state, zip, timezone, country, name);

    }
}
