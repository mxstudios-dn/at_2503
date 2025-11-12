package utils;

import org.w3c.dom.*;
//import javax.xml.catalog.Catalog;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLHelper {
    public static List<utils.Book> loadBooks(String filePath) {
        List<utils.Book> books = new ArrayList<>();
        try {
            //Tạo DocumentBuilder để đọc file XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Parse (phân tích) file XML và lưu vào đối tượng Document
            Document doc = builder.parse(filePath);
            doc.getDocumentElement().normalize();

            //Lấy danh sách các node<book>
            NodeList nodeList = doc.getElementsByTagName("book");

            //Duyệt từng node<book>
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element bookElement = (Element) nodeList.item(i);

                String id = bookElement.getAttribute("id");
                String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String genre = bookElement.getElementsByTagName("genre").item(0).getTextContent();
                double price = Double.parseDouble(bookElement.getElementsByTagName("price").item(0).getTextContent());
                String publishDate = bookElement.getElementsByTagName("publish_date").item(0).getTextContent();
                String description = bookElement.getElementsByTagName("description").item(0).getTextContent();

                utils.Book book = new utils.Book(id, author, title, genre, price, publishDate, description);
                books.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return books;
    }
}
