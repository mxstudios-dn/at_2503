package utils;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

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
        XPathFactory xpathFactory = XPathFactory.newInstance();
        this.xpath = xpathFactory.newXPath();
    }

    /**
     * Get the parsed XML Document.
     * @return Java XML Document object
     */
    public Document getXmlDocument() {
        return xmlDocument;
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
}
