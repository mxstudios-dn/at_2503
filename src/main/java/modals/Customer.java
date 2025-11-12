package modals;

import java.util.List;

public class Customer {
    private String id;
    private String name;
    private String phone;
    private List<Address> addresses; // Một khách hàng có nhiều địa chỉ

    // Constructor
    public Customer(String id, String name, String phone, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.addresses = addresses;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public List<Address> getAddresses() { return addresses; }

    // toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer [ID=" + id + "]\n");
        sb.append("  Name: " + name + "\n");

        // Xử lý nếu phone bị thiếu
        if (phone != null && !phone.isEmpty()) {
            sb.append("  Phone: " + phone + "\n");
        }

        sb.append("  Addresses:\n");
        // In danh sách các địa chỉ
        for (Address addr : addresses) {
            sb.append(addr.toString() + "\n");
        }
        sb.append("------------------------------------");
        return sb.toString();
    }
}