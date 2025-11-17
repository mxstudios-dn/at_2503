package vn.vti.academy;

<<<<<<< Updated upstream
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}
=======
import com.opencsv.exceptions.CsvException;
import modals.Address;
import utils.Constants;
import utlis.CSVHelper;
import utlis.Helper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        //  BookService bookService = new BookService();
        //  bookService.loadAndShowBooks();

//        CustomerService customerService = new CustomerService();
//        XMLCustomerHelper xmlCustomerHelper = new XMLCustomerHelper();
//        customerService.loadAndShowCustomers();
//        System.out.println("-------------");
//        xmlCustomerHelper.showCustomerById("55000");

//        MoviesService moviesService = new MoviesService();
//        moviesService.loadAnhShowMovies();
//        CSVHelper csvHelper = new CSVHelper(Constants.CSV_PATH);
//        List<String[]> csvData = csvHelper.getCsvData();
//        for(String[] row: csvData){
//            System.out.println(String.join("|", row));

            // Load CSV addresses
            CSVHelper csvHelper = new CSVHelper(Constants.CSV_PATH);
            List<Address> addresses = csvHelper.getAddress();
           // System.out.println(addresses);
        Helper helper = new Helper();
        System.out.println(helper.randomObject(Collections.singletonList(addresses)));




        }
        }

>>>>>>> Stashed changes
