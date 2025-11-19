package utils;

import module.Customer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLHelper {
    public  static List<Customer> loadCustomer(String filePath){
        List<Customer> customers = new ArrayList<>();

        try {
            File file = new File(filePath);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();

            Document doc = dbBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Customer");

            for (int i =0; i< nodeList.getLength();i++){
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element e = (Element) node;

                    Customer customer = new Customer(
                            e.getAttribute("CustomerId"),
                            e.getElementsByTagName("FirstName").item(0).getTextContent(),
                            e.getElementsByTagName("LastName").item(0).getTextContent(),
                            e.getElementsByTagName("Email").item(0).getTextContent(),
                            e.getElementsByTagName("Phone").item(0).getTextContent(),
                            e.getElementsByTagName("DateOfBirth").item(0).getTextContent(),
                            e.getElementsByTagName("CustomerRole").item(0).getTextContent(),
                            Boolean.parseBoolean(e.getElementsByTagName("IsActive").item(0).getTextContent())
                    );

                    customers.add(customer);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }
}
