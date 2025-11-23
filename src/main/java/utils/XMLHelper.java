package utils;

import model.Customer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Person;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XMLHelper extends Helper{
    private Document xlmDocument;
    private XPath xpath;
    //File xmlFile = new File("path/to/your/file.xml");
//    public static List<Person> readPersonsFromXml(String filePath)
//            throws IOException, ParserConfigurationException, SAXException {
//
//        List<Person> persons = new ArrayList<>();
//
//        File file = new File(filePath);
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document doc = builder.parse(file);
//
//        doc.getDocumentElement().normalize();
//
//        NodeList envList = doc.getElementsByTagName("enviroment");
//
//        for (int i = 0; i < envList.getLength(); i++) {
//            Element env = (Element) envList.item(i);
//            String envName = env.getAttribute("name");
//
//            NodeList personList = env.getElementsByTagName("Person");
//
//            for (int j = 0; j < personList.getLength(); j++) {
//                Element personElement = (Element) personList.item(j);
//
//                String name = personElement.getElementsByTagName("Name").item(0).getTextContent();
//                int age = Integer.parseInt(personElement.getElementsByTagName("Age").item(0).getTextContent());
//                String email = personElement.getElementsByTagName("Email").item(0).getTextContent();
//
//                Person person = new Person(name, age, email, envName);
//                persons.add(person);
//            }
//        }
//        return persons;
//    }


}
