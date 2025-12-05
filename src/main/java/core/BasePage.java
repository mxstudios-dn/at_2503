package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.Helper;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class BasePage extends Helper {
    protected WebDriver webDriver;

    @SuppressWarnings("null")
    public void openSite() {
        logger.info("Navigating to URL: {}", TestSettings.BASE_URL);
        DriverManager.getDriver().get(TestSettings.BASE_URL);
        logger.info("Navigation to URL: {} completed", TestSettings.BASE_URL);
    }

    public WebDriverWait getWait(long waitTime) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime));
    }

    @SuppressWarnings("null")
    private WebElement findElement(By selector) {
        return getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    protected void enterText(By selector, String text) {
        logger.info("Entering text {}", text);
        findElement(selector).sendKeys(text);
    }

    @SuppressWarnings("null")
    protected String getElementAttribute(By selector, String attributeName) {
        logger.info("Getting attribute {} from element {}", attributeName, selector);
        return findElement(selector).getAttribute(attributeName);
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
        logger.info("Verifying condition is true");
        assertTrue(condition, message);
    }

    protected void verifyFalse(boolean condition, String message) {
        logger.info("Verifying condition is false");
        assertFalse(condition, message);
    }

    protected void verifyEquals(Object expected, Object actual, String message) {
        logger.info("Verifying equality of expected and actual values");
        assertEquals(expected, actual, message);
    }

    @SuppressWarnings("null")
    protected void verifyElementVisible(By selector, String errorMessage) {
        logger.info("Verifying visibility of element {}", selector);
        try {
            getWait(0).until(ExpectedConditions.visibilityOfElementLocated(selector));
            logger.info("Element {} is visible", selector);
        } catch (Exception e) {
            logger.error("Element {} is not visible: {}", selector, errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

}
