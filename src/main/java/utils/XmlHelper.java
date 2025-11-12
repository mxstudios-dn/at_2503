package utils;

import modals.Address;
import modals.Book;
import modals.Customer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp Helper TĨNH (static) để đọc và phân tích file XML.
 * Tất cả các phương thức đều là static.
 */
public final class XmlHelper { // (1) Thêm 'final'

    /**
     * (2) Constructor private để ngăn việc tạo đối tượng
     * Đây là lớp utility, không cho phép khởi tạo: new XmlHelper()
     */
    private XmlHelper() {
    }

    /**
     * (3) HÀM HELPER CHUNG (Private)
     * Tải và parse file XML, dùng cho tất cả các hàm parser
     */
    private static Document loadXmlDocument(String filepath) throws Exception {
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        return doc;
    }
    /**
     * (4) HÀM HELPER CHUNG (Public)
     * Lấy giá trị text từ một tag con bên trong một Element cha
     */
    public static String getTagValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            // Thêm kiểm tra null để an toàn hơn
            if (node != null && node.getTextContent() != null) {
                return node.getTextContent().trim();
            }
        }
        return ""; // Trả về rỗng nếu không tìm thấy
    }

    // --- CÁC PHƯƠNG THỨC PARSER CHUYÊN BIỆT ---
    /**
     * Parse file book.xml
     * @param filepath Đường dẫn đến file book.xml
     * @return List<Book>
     */
    public static List<Book> parseBooks(String filepath) throws Exception {
        // (5) GỌI HÀM HELPER CHUNG
        Document doc = loadXmlDocument(filepath);
        List<Book> bookList = new ArrayList<>();

        NodeList nodeList = doc.getElementsByTagName("book");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element bookElement = (Element) node;

                String id = bookElement.getAttribute("id");
                // (6) SỬ DỤNG HELPER CHUNG
                String author = getTagValue(bookElement, "author");
                String title = getTagValue(bookElement, "title");
                String genre = getTagValue(bookElement, "genre");

                // Thêm xử lý lỗi nếu price bị rỗng
                double price = 0.0;
                String priceStr = getTagValue(bookElement, "price");
                if (priceStr != null && !priceStr.isEmpty()) {
                    price = Double.parseDouble(priceStr);
                }

                String publishDate = getTagValue(bookElement, "publish_date");
                String description = getTagValue(bookElement, "description");

                Book book = new Book(id, author, title, genre, price, publishDate, description);
                bookList.add(book);
            }
        }
        return bookList;
    }
    /**
     * Parse file customers.xml
     * @param filepath Đường dẫn đến file customers.xml
     * @return List<Customer>
     */
    public static List<Customer> parseCustomers(String filepath) throws Exception {
        // (5) GỌI HÀM HELPER CHUNG
        Document doc = loadXmlDocument(filepath);
        List<Customer> customerList = new ArrayList<>();

        NodeList customerNodes = doc.getElementsByTagName("customer");
        for (int i = 0; i < customerNodes.getLength(); i++) {
            Element customerElement = (Element) customerNodes.item(i);

            String id = customerElement.getAttribute("id");
            // (6) SỬ DỤNG HELPER CHUNG
            String name = getTagValue(customerElement, "name");
            String phone = getTagValue(customerElement, "phone");

            List<Address> addressList = new ArrayList<>();
            NodeList addressNodes = customerElement.getElementsByTagName("address");
            for (int j = 0; j < addressNodes.getLength(); j++) {
                Element addressElement = (Element) addressNodes.item(j);

                // (6) SỬ DỤNG HELPER CHUNG
                String street = getTagValue(addressElement, "street");
                String city = getTagValue(addressElement, "city");
                String state = getTagValue(addressElement, "state");
                String zip = getTagValue(addressElement, "zip");

                addressList.add(new Address(street, city, state, zip));
            }

            Customer customer = new Customer(id, name, phone, addressList);
            customerList.add(customer);
        }
        return customerList;
    }
}