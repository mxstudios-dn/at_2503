package utils

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class XMLHelper {
    public static ArrayList<Book> loadBooks(String filePath) {
        ArrayList<Book> books = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            if (!xmlFile.exists()) {
                System.err.println(" XML file not found: " + xmlFile.getAbsolutePath());
                return books;
            }
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String id = element.getAttribute("id");
                    String author = element.getElementsByTagName("author").item(0).getTextContent();
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String genre = element.getElementsByTagName("genre").item(0).getTextContent();
                    double price = Double.parseDouble(element.getElementsByTagName("price").item(0).getTextContent());
                    String publishDate = element.getElementsByTagName("publish_date").item(0).getTextContent();
                    String description = element.getElementsByTagName("description").item(0).getTextContent().trim();

                    Book book = new Book(id, author, title, genre, price, publishDate, description);
                    books.add(book);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}