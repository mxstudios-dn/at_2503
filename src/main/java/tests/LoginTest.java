package tests;

import core.SeleniumDriverBase;
import org.apache.logging.log4j.core.util.Constants;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ManagerPage;
import utils.Constant;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends TestSettings {

    @Test
    @Order(1)
    public void testCase01_blankUserId() {
        loginPage.openLoginPage(Constant.GURU99_LOGIN_PAGE);

        loginPage.setUserId("");
        loginPage.setPassword("somepass");
        loginPage.clickLogin();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();

        Assertions.assertEquals("User or Password is not valid", alertText);
    }

    @Test
    @Order(2)
    public void testCase02_blankPassword() {
        loginPage.openLoginPage(Constant.GURU99_LOGIN_PAGE);

        loginPage.setUserId("someuser");
        loginPage.setPassword("");
        loginPage.clickLogin();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();

        Assertions.assertEquals("User or Password is not valid", alertText);
    }

    @Test
    @Order(3)
    public void testCase03_validLogin() {
        loginPage.openLoginPage(Constant.GURU99_LOGIN_PAGE);

        loginPage.setUserId(Constant.VALID_LOGIN);
        loginPage.setPassword(Constant.VALID_PASS);
        loginPage.clickLogin();

        ManagerPage managerPage = new ManagerPage(driver);
        String text = managerPage.getManagerIdText();

        Assertions.assertTrue(text.contains("Manger Id"));
    }
}
