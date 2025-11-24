package vn.vti.academy;

import core.SeleniumDriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws  InterruptedException{

        SeleniumDriverBase driverBase = new SeleniumDriverBase();
        WebDriver driver = driverBase.getDriver("firefox");

        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String[] menuItems = {
                "Downloads",
                "Documentation",
                "Projects",
                "Support",
                "Blog"
        };

        for (String item : menuItems) {
            wait.until(ExpectedConditions
                            .elementToBeClickable(By.linkText(item)))
                    .click();
            System.out.println("Navigated to: " + driver.getCurrentUrl());

            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }

        driver.quit();
    }
}
