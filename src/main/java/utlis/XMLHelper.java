package utlis;
import modals.Address;
import modals.AddressDetails;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLHelper {

    public static List<Address> loadAddresses(String xmlFileName) {
        List<Address> list = new ArrayList<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Dòng 26 của bạn đây.
            // Dòng này sẽ tìm file trong thư mục resources
            InputStream inputStream = XMLHelper.class.getClassLoader().getResourceAsStream(xmlFileName);

            if (inputStream == null) {
                // Ném ra lỗi rõ ràng
                throw new IOException("Không tìm thấy file: " + xmlFileName);
            }

            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            NodeList addressNodes = doc.getElementsByTagName("Address");

            for (int i = 0; i < addressNodes.getLength(); i++) {
                Node addressNode = addressNodes.item(i);

                if (addressNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element addressElement = (Element) addressNode;
                    String name = getTagValue("Name", addressElement);
                    Node detailsNode = addressElement.getElementsByTagName("Details").item(0);

                    if (detailsNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element detailsElement = (Element) detailsNode;
                        String street = getTagValue("Street", detailsElement);
                        String city = getTagValue("City", detailsElement);
                        String state = getTagValue("State", detailsElement);
                        String zip = getTagValue("Zip", detailsElement);
                        String timeZone = getTagValue("TimeZone", detailsElement);

                        AddressDetails details = new AddressDetails(street, city, state, zip, timeZone);
                        Address address = new Address(name, details);
                        list.add(address);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}