package utils;

import model.Address;
import model.Customer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerXMLHelper {
    public static List<Customer> readCustomers(String filePath) throws Exception {
        List<Customer> customers = new ArrayList<>();

        File file = new File(filePath);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList customerNodes = doc.getElementsByTagName("customer");

        for (int i = 0; i < customerNodes.getLength(); i++) {
            Element customerElement = (Element) customerNodes.item(i);
            String id = customerElement.getAttribute("id");
            String name = getTagValue(customerElement, "name");

            List<Address> addresses = new ArrayList<>();
            NodeList addressNodes = customerElement.getElementsByTagName("address");

            for (int j = 0; j < addressNodes.getLength(); j++) {
                Element addr = (Element) addressNodes.item(j);
                String street = getTagValue(addr, "street");
                String city   = getTagValue(addr, "city");
                String state  = getTagValue(addr, "state");
                String zip    = getTagValue(addr, "zip");

                addresses.add(new Address(street, city, state, zip));
            }

            customers.add(new Customer(id, name, addresses));
        }

        return customers;
    }
    public static void printCustomerById(List<Customer> customers, String targetId) {
        for (Customer c : customers) {
            if (c.getId().equals(targetId)) {
                System.out.println("Customer Name: " + c.getName());
                System.out.println("Addresses:");
                for (Address addr : c.getAddresses()) {
                    System.out.println(" - " + addr.getStreet() + ", " +
                            addr.getCity() + ", " +
                            addr.getState());
                }
                return;
            }
        }
        System.out.println("Không tìm thấy customer với ID: " + targetId);
    }
    private static String getTagValue(Element parent, String tagName) {
        NodeList nodeList = parent.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0 && nodeList.item(0) != null) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }
}
