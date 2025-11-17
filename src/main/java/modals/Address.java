package modals;
public class Address {
    private String name;
    private AddressDetails details;

    public Address(String name, AddressDetails details) {
        this.name = name;
        this.details = details;
    }

    @Override
    public String toString() {
        return
                "Tên địa điểm: " + name + "\n" +
                        "      Chi tiết: " + details.toString() + "\n" +
                        "------------------------------------------------------------";
    }
}

