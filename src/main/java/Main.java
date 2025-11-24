
import com.opencsv.exceptions.CsvException;
import core.SeleniumDriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws CsvException, IOException {
        SeleniumDriverBase driverBase = new SeleniumDriverBase();
        WebDriver driver = driverBase.getDriver();
        driver.get("https://www.example.com");
        driver.quit();
    }
}
