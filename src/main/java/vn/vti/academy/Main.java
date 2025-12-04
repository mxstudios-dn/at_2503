package vn.vti.academy;

import core.SeleniumDriverBase;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import tests.TestSettings;
import utils.Constant;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Start Selenium driver
        SeleniumDriverBase driverBase = new SeleniumDriverBase();
        WebDriver driver = driverBase.getDriver(); // default browser from your driver base

        try {
            // Open the Guru99 login page
            driver.get(Constant.GURU99_LOGIN_PAGE);
            driver.manage().window().maximize();

            // Instantiate the page
            LoginPage loginPage = new LoginPage(driver);

            // Example Action: valid login
            loginPage.setUserId(Constant.VALID_LOGIN);
            loginPage.setPassword(Constant.VALID_PASS);
            loginPage.clickLogin();

            // Show current state
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page Title: " + driver.getTitle());

        } catch (Exception e) {
            System.out.println("An error occurred during execution:");
            e.printStackTrace();
        } finally {
            // Quit the session
            driverBase.quitDriver();
            System.out.println("Browser closed.");
        }
    }
}
