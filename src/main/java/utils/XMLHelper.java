package utils;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Element;
import modals.BookModal;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLHelper extends Helper{
    private final Document xmlDocument;
    private final XPath xpath;

    /**
     * Constructor to load and parse an XML file.
     * @param filePath
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public XMLHelper(String filePath) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        factory.setValidating(false);
        factory.setIgnoringElementContentWhitespace(false);
        DocumentBuilder builder = factory.newDocumentBuilder();

        this.xmlDocument = builder.parse(filePath);
        this.xmlDocument.getDocumentElement().normalize();
        XPathFactory xpathFactory = XPathFactory.newInstance();

        this.xpath = xpathFactory.newXPath();
    }

    /**
     * Get the parsed XML Document.
     * @return Java XML Document object
     */
    public Document getXmlDocument() {
        return this.xmlDocument;
    }

    /**
     * Get a single Node by XPath expression.
     * @return Node
     */
    public NodeList getNodesByXPath(String expression) throws XPathExpressionException {
        return (NodeList) xpath.evaluate(expression, xmlDocument, XPathConstants.NODESET);
    }

    /**
     * Get value of a node by XPath expression.
     * @param expression
     * @return
     * @throws XPathExpressionException
     */
    public String getValueByXPath(String expression) throws XPathExpressionException {
        return xpath.evaluate(expression, xmlDocument);
    }

    /**
     * Get attribute value of a node by XPath expression.
     * @param expression
     * @param attributeName
     * @return
     * @throws XPathExpressionException
     */
    public String getAttributeByXPath(String expression, String attributeName) throws XPathExpressionException {
        Node node = (Node) xpath.evaluate(expression, xmlDocument, XPathConstants.NODE);
        if (node != null && node.getAttributes() != null) {
            Node attr = node.getAttributes().getNamedItem(attributeName);
            if (attr != null) {
                return attr.getNodeValue();
            }
        }
        return null;
    }

    /**
     * Get URL based on the current environment from .env file.
     * @return URL as String
     * @throws XPathExpressionException
     */
    public String getUrl() throws XPathExpressionException {
        String environment = this.dotenv.get("ENV");
        String expression = String.format("//environment[@name='%s']/url", environment);
        return getValueByXPath(expression);
    }

    /**
     * Helper method to safely retrieve the text content of a child element.
     */
    private static String getElementValue(Element parentElement, String tagName) {
        try {
            // Get the list of elements with the given tag name (e.g., "author")
            NodeList nodeList = parentElement.getElementsByTagName(tagName);
            if (nodeList != null && nodeList.getLength() > 0) {
                Element element = (Element) nodeList.item(0);
                // Return the text content, stripped of leading/trailing whitespace
                return element.getTextContent().trim();
            }
        } catch (Exception e) {
            // Log or handle case where tag is missing if necessary
        }
        return "";
    }

    public List<BookModal> getAllBooks() {
        List<BookModal> books = new ArrayList<BookModal>();

        try {
            // 2. Get all <book> nodes
            NodeList nodeList = this.xmlDocument.getElementsByTagName("book");

            // 3. Iterate through each <book> node
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) node;

                    // Extract Book data
                    String id = bookElement.getAttribute("id");
                    String author = getElementValue(bookElement, "author");
                    String title = getElementValue(bookElement, "title");
                    String genre = getElementValue(bookElement, "genre");
                    String publishDate = getElementValue(bookElement, "publish_date");
                    String description = getElementValue(bookElement, "description");

                    // Parse price safely
                    double price = 0.0;
                    try {
                        String priceStr = getElementValue(bookElement, "price");
                        price = Double.parseDouble(priceStr);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing price for book ID: " + id);
                    }

                    // Create Book object and add to list
                    BookModal book = new BookModal(id, author, title, genre, price, publishDate, description);
                    books.add(book);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }
}
