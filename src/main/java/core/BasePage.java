package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Helper;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage extends Helper {
    protected DriverManager driverManager;

    public BasePage() {
        logger.debug("{} initialized", this.getClass().getSimpleName());
    }

    public void setDriverManager(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void openGuru99DemoSite() {
        logger.info("Navigating to URL: {}", TestSettings.BASE_URL);
        driverManager.getDriver().get(TestSettings.BASE_URL);
    }

    private WebElement findElement(By selector) {
        //TODO: Handle waiting for element to be visible
        return driverManager.getDriver().findElement(selector);
    }

    protected void enterText(By selector, String text) {
        logger.info("Entering text {}", text);
        findElement(selector).sendKeys(text);
    }

    protected void clickButton(By selector) {
        logger.info("Clicking button {}", selector);
        findElement(selector).click();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected String getElementText(By selector) {
        String text = findElement(selector).getText();
        logger.info("Retrieved text '{}' from element {}", text, selector);
        return text;
    }

    protected void verifyTrue(boolean condition, String message) {
        assertTrue(condition, message);
    }


}
