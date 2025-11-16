package model;

import java.util.List;

public class Customer {
    private String id;
    private String name;
    private List<Address> addresses;

    public Customer(String id, String name, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Address> getAddresses() { return addresses; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer Name: ").append(name).append("\n");
        sb.append("Addresses:\n");
        for (Address addr : addresses) {
            sb.append(" - ").append(addr).append("\n");
        }
        return sb.toString();
    }
}

