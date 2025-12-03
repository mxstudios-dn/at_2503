
import com.opencsv.exceptions.CsvException;
import core.DriverManager;
import core.TestSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws CsvException, IOException {
//        Launch Chrome browser
        DriverManager driverManager = new DriverManager("chrome");

//        Navigate to the base URL
        driverManager.navigateTo(TestSettings.BASE_URL);

//        Login => LoginPage
//       Init WebElements
        WebElement txtUsername = driverManager.findElement(By.id("username"));
        WebElement txtPassword = driverManager.findElement(By.id("password"));
        WebElement btnLogin = driverManager.findElement(By.id("log-in"));

        txtUsername.sendKeys("test");
        txtPassword.sendKeys("test");
        btnLogin.click();

//        Verify login success => JUnit/TestNG: Assertions
        String crrTitle = driverManager.getTitle();
        System.out.println("Is Dashboard page displayed? " + crrTitle.equals("ACME demo app"));

        WebElement icoMessage = driverManager.findElement(By.xpath("//i[contains(@class, 'os-icon-mail')]"));
        System.out.println("Is message icon displayed? " + icoMessage.isDisplayed());

//        Post-conditions
        driverManager.quit();
    }
}
