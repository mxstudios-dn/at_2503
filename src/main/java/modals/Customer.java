package modals;

import java.util.List;

public class Customer {
    private String id;
    private String name;
    private List<Address> addresses;

    public Customer(String id, String name, List<Address> address) {
        this.id = id;
        this.name = name;
        this.addresses = address;
    }


    @Override
    public String toString() {
        //  StringBuilder sb = new StringBuilder();
        // sb.append(String.format("%s, %s \n", id, name ));
        // sb.append("Addresses:\n");

        String result = String.format("%s, %s\nAddresses:\n", id, name);

        for (Address addr : addresses) {
            result +=  addr.toString() + "\n";
        }

        return result;
    }

    public String getId(){
        return id;
    }
}




