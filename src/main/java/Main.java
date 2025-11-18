
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import javacore.BookShop;
import modals.Book;
import utils.CSVHelper;
import utils.Constants;
import utils.XMLHelper;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws CsvException, IOException {
        CSVHelper csvHelper = new CSVHelper(Constants.ADDRESSES_FILE_PATH);
        List<String[]> csvData = csvHelper.getCsvData();
        for (String[] row : csvData) {
            System.out.println(String.join(" | ", row));
        }
    }
}
