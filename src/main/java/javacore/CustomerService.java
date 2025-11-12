package javacore;

import modals.Book;
import modals.Customer;
import org.xml.sax.SAXException;
import utils.Constants;
import utlis.XMLCustomerHelper;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    public void loadAndShowCustomers() throws IOException, ParserConfigurationException, SAXException {
        // Gọi XMLHelper để đọc file XML
        List<Customer> customers = XMLCustomerHelper.loadCustomers(Constants.CUSTOMER_PATH);


        // In danh sách sách ra màn hình
        System.out.println("Danh sách customer:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

    }

}
