package utlis;

import modals.Address;
import modals.Book;
import modals.Customer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLCustomerHelper {
    private static List<Customer> customers = new ArrayList<>();

    public static List<Customer> loadCustomers(String filePath) throws IOException, ParserConfigurationException, SAXException {
        //Tạo DocumentBuilder để đọc file XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //Parse file XML và lưu vào đối tượng Document
        Document doc = builder.parse(filePath);
        doc.getDocumentElement().normalize();

        //Lấy danh sách các Node
        NodeList nodeList = doc.getElementsByTagName("customer");
        //Duyệt danh sách customer
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element customerElement = (Element) nodeList.item(i);

            String id = customerElement.getAttribute("id");
            String name = customerElement.getElementsByTagName("name").item(0).getTextContent();


             List<Address> addresses = new ArrayList<>();
            NodeList addressNodes = customerElement.getElementsByTagName("address");
            for (int j = 0; j < addressNodes.getLength(); j++) {
                Element addr = (Element) addressNodes.item(j);
                String street = getTagValue(addr, "street");
                String city = getTagValue(addr, "city");
                String state = getTagValue(addr, "state");
                String zip = getTagValue(addr, "zip");
                addresses.add(new Address(street, city, state, zip));
            }

            customers.add(new Customer(id, name, addresses));

        }
        return customers;
    }

    private static String getTagValue(Element parent, String tagName) {
        NodeList list = parent.getElementsByTagName(tagName);
        if (list.getLength() > 0) {
            return list.item(0).getTextContent();
        }
        return null;
    }
    public void showCustomerById(String id) {
        // Duyệt danh sách khách hàng
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                System.out.println(c); // sẽ gọi c.toString()
                return; // dừng sau khi tìm thấy
            }
        }
        // Nếu không tìm thấy
        System.out.println("Không tìm thấy Customer có id: " + id);
    }

}
