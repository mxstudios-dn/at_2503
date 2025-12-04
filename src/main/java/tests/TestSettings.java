package tests;

import core.SeleniumDriverBase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ManagerPage;
import utils.Constant;

public class TestSettings {

    protected static SeleniumDriverBase driverBase;
    protected static WebDriver driver;
    protected static LoginPage loginPage;

    @BeforeAll
    public static void globalSetup() {
        driverBase = new SeleniumDriverBase();
        driver = driverBase.getDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterAll
    public static void globalTeardown() {
        driverBase.quitDriver();
    }
}
