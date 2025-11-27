
import com.opencsv.exceptions.CsvException;
import core.DriverManager;
import core.TestSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws CsvException, IOException {
        DriverManager driverManager = new DriverManager("chrome");
        driverManager.navigateTo(TestSettings.BASE_URL);
    }
}
