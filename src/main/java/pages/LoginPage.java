package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By userIdField = By.name("uid");
    private By passwordField = By.name("password");
    private By loginButton = By.name("btnLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage(String url) {
        driver.get(url);
    }

    public void setUserId(String userId) {
        driver.findElement(userIdField).clear();
        driver.findElement(userIdField).sendKeys(userId);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
