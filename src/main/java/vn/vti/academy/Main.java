package vn.vti.academy;
//import Exercise.ArrayListExercise;
//mport java.util.ArrayList;

import io.github.cdimascio.dotenv.Dotenv;
//import jdk.vm.ci.meta.Constant;
import model.Customer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import utils.Constant;
import utils.CustomerXMLHelper;
import utils.XMLHelper;
import model.Person;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Dotenv dotenv = Dotenv.load();
        //try {
//            File file = new File("src/main/resources/Person.xml"); // Đường dẫn tới file XML
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document doc = builder.parse(file);
//
//            doc.getDocumentElement().normalize();
//
//            NodeList envList = doc.getElementsByTagName("enviroment");
//
//            for (int i = 0; i < envList.getLength(); i++) {
//                Element env = (Element) envList.item(i);
//                String envName = env.getAttribute("name");
//
//                NodeList personList = env.getElementsByTagName("Person");
//
//                for (int j = 0; j < personList.getLength(); j++) {
//                    Element person = (Element) personList.item(j);
//
//                    String name = person.getElementsByTagName("Name").item(0).getTextContent();
//                    String age = person.getElementsByTagName("Age").item(0).getTextContent();
//                    String email = person.getElementsByTagName("Email").item(0).getTextContent();
//
//                    System.out.println("Environment: " + envName);
//                    System.out.println("Name: " + name);
//                    System.out.println("Age: " + age);
//                    System.out.println("Email: " + email);
//                    System.out.println("---------------------------");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//            String xmlPath = Constant.PERSON_FILE_PATH; // Đường dẫn tới file XML
//            List<Person> personList = XMLHelper.readPersonsFromXml(xmlPath);
//
//            for (Person p : personList) {
//                System.out.println(p);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ParserConfigurationException e) {
//            throw new RuntimeException(e);
//        } catch (SAXException e) {
//            throw new RuntimeException(e);
//        }
            // Customer
        try {
            String xmlPath = Constant.CUSTOMER_FILE_PATH; // hoặc "customers.xml"
            List<Customer> customerList = CustomerXMLHelper.readCustomers(xmlPath);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập ID của customer cần tìm: ");
            String inputId = scanner.nextLine();

            CustomerXMLHelper.printCustomerById(customerList, inputId);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
