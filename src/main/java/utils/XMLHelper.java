package utils;

import model.Customer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Person;
import model.CustomerBT2;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XMLHelper {

    public static List<CustomerBT2> readCustomersFromXml(String filePath)
            throws IOException, ParserConfigurationException, SAXException {

        List<CustomerBT2> customers = new ArrayList<>();

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File(filePath));
        doc.getDocumentElement().normalize();

        NodeList customerNodes = doc.getElementsByTagName("Customer");

        for (int i = 0; i < customerNodes.getLength(); i++) {
            Element customerEnv = (Element) customerNodes.item(i);

            NodeList personNodes = customerEnv.getElementsByTagName("Person");
            for (int j = 0; j < personNodes.getLength(); j++) {
                Element personElement = (Element) personNodes.item(j);

                String firstName   = getTagValue(personElement, "FirstName");
                String lastName    = getTagValue(personElement, "LastName");
                String email       = getTagValue(personElement, "Email");
                String customerRole= getTagValue(personElement, "CustomerRole");
                String dateOfBirth = getTagValue(personElement, "DateOfBirth");
                String phoneNumber = getTagValue(personElement, "Phone");

                // Phone có thể null → kiểm tra trước khi parse
//                String phoneStr = getTagValue(personElement, "Phone");
//                int phoneNumber = (phoneStr != null && !phoneStr.isEmpty())
//                        ? Integer.parseInt(phoneStr) : 0;

                // IsActive ép kiểu sang boolean
                String isActiveStr = getTagValue(personElement, "IsActive");
                boolean isActive = Boolean.parseBoolean(isActiveStr);

                customers.add(new CustomerBT2(
                        firstName, lastName, email, customerRole, dateOfBirth, phoneNumber, isActive
                ));
            }
        }
        return customers;
    }

    // 🔹 Hàm tiện ích lấy giá trị tag, tránh lặp lại
    private static String getTagValue(Element parent, String tagName) {
        NodeList nodeList = parent.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0 && nodeList.item(0) != null) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }
}

