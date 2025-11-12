package vn.vti.academy;

import javacore.BookService;
import javacore.CustomerService;
import modals.Book;
import org.xml.sax.SAXException;
import utils.Constants;
import utils.XMLHelper;
import utlis.XMLCustomerHelper;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
      //  BookService bookService = new BookService();
      //  bookService.loadAndShowBooks();

        CustomerService customerService = new CustomerService();
        XMLCustomerHelper xmlCustomerHelper = new XMLCustomerHelper();
        customerService.loadAndShowCustomers();
        System.out.println("-------------");
        xmlCustomerHelper.showCustomerById("55000");



    }
}
