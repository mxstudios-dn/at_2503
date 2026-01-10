package core;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;
import utils.Helper;

public class BasePage extends Helper {
    
    /**
     * Constructs a new BasePage and initializes the WebDriver instance for the current thread.
     */
    public BasePage() {
        super();
    }

    /**
     * Navigates the browser to the specified URL.
     * @param url The URL to navigate to.
     */
    public void navigateTo(String url) {
        if (url == null) {
            throw new IllegalArgumentException("URL cannot be null");
        }
        logger.info("[Base Page] Navigating to URL: {}", url);
        DriverManager.getDriver().get(url);
    }

    private WebElement findElement(By selector) {
        if (selector == null) {
            throw new IllegalArgumentException("Selector cannot be null");
        }
        return getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    /**
     * Checks if the element located by the selector is displayed on the page.
     * @param selector The By selector for the element.
     * @return true if displayed, false otherwise.
     */
    protected boolean isElementDisplayed(By selector) {
        try {
            return findElement(selector).isDisplayed();
        } catch (Exception e) {
            logger.warn("Element {} is not displayed: {}", selector, e.getMessage());
            return false;
        }
    }

    /**
     * Returns a WebDriverWait instance for the given wait time (in seconds).
     * @param waitTime The wait time in seconds.
     * @return WebDriverWait instance.
     */
    public WebDriverWait getWait(long waitTime) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime));
    }

    /**
     * Waits until the element located by the selector is invisible.
     * @param selector The By selector for the element.
     */
    protected void waitForElementInvisible(By selector) {
        if (selector == null) {
            throw new IllegalArgumentException("Selector cannot be null");
        }
        getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    private WebElement waitForElementClickable(By selector) {
        if (selector == null) {
            throw new IllegalArgumentException("Selector cannot be null");
        }
        return getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.elementToBeClickable(selector));
    }

    /**
     * Enters text into the element located by the selector, waiting for visibility.
     * @param selector The By selector for the element.
     * @param text The text to enter.
     */
    protected void enterText(By selector, String text) {
        logger.info("[Base Page] Entering text {}", text);
        findElement(selector).sendKeys(text);
    }

    /**
     * Enters text into the element located by the selector without waiting for visibility.
     * @param selector The By selector for the element.
     * @param text The text to enter.
     */
    protected void enterTextWithoutWait(By selector, String text) {
        if (selector == null) {
            throw new IllegalArgumentException("Selector cannot be null");
        }
        logger.info("[Base Page] Entering text {}", text);
        DriverManager.getDriver().findElement(selector).sendKeys(text);
    }

    /**
     * Gets the value of the specified attribute from the element located by the selector.
     * @param selector The By selector for the element.
     * @param attributeName The attribute name.
     * @return The attribute value, or empty string if not present.
     */
    protected String getElementAttribute(By selector, String attributeName) {
        logger.info("[Base Page] Getting attribute {} from element {}", attributeName, selector);
        if (attributeName == null) {
            throw new IllegalArgumentException("Selector cannot be null");
        }
        String value = findElement(selector).getDomAttribute(attributeName);
        return value != null ? value : "";
    }

    /**
     * Gets the value or text content from the element located by the selector.
     * @param selector The By selector for the element.
     * @return The value or text content.
     */
    protected String getElementValue(By selector) {
        logger.info("[Base Page] Getting value from element {}", selector);
        WebElement element = findElement(selector);
        return element.getText().isEmpty() ? element.getDomProperty("value") : element.getText();
    }

    /**
     * Clicks the element located by the selector, waiting until it is clickable.
     * @param selector The By selector for the element.
     */
    protected void clickElement(By selector) {
        logger.info("[Base Page] Clicking element {}", selector);
        waitForElementClickable(selector).click();
    }

    /**
     * Executes the given JavaScript in the context of the current page.
     * @param script The JavaScript code to execute.
     */
    protected void executeJavaScript(String script) {
        if (script == null) {
            throw new IllegalArgumentException("JavaScript script cannot be null");
        }
        logger.info("[Base Page] Executing JavaScript: {}", script);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(script);
    }

    /**
     * Gets the visible text from the element located by the selector.
     * @param selector The By selector for the element.
     * @return The text content.
     */
    protected String getElementText(By selector) {
        String text = findElement(selector).getText();
        logger.info("[Base Page] Retrieved text '{}' from element {}", text, selector);
        return text;
    }


    /**
     * Switches the driver's context to the currently active alert.
     * @return The Alert object.
     */
    @Step("Switch to alert")
    protected Alert switchToAlert() {
        logger.info("[Base Page] Switching to alert");
        return DriverManager.getDriver().switchTo().alert();
    }

    /**
     * Accepts the given alert.
     * @param alert The Alert to accept.
     */
    @Step("Accepting alert")
    protected void acceptAlertAction(Alert alert) {
        logger.info("[Base Page] Accepting alert");
        alert.accept();
    }

    /**
     * Dismisses the given alert.
     * @param alert The Alert to dismiss.
     */
    @Step("Dismissing alert")
    protected void dismissAlertAction(Alert alert) {
        logger.info("[Base Page] Dismissing alert");
        alert.dismiss();
    }

    @Step("Check if alert is disappeared")
    public boolean isAlertDisappeared() {
        logger.info("[Base Page] Checking if alert is disappeared");
        try {
            getWait(0).until(ExpectedConditions.alertIsPresent());
            return false;
        } catch (Exception e) {
            logger.info("[Base Page] Alert is not present as expected");
        }
        return true;
    }

    @Step("Get alert message")
    public String getAlertMessage() {
        logger.info("[Base Page] Getting alert message");
        Alert alert = switchToAlert();
        String message = alert.getText();
        logger.info("[Base Page] Alert message: {}", message);
        return message;
    }

    @Step("Verify True Condition: {condition}")
    public void verifyTrue(boolean condition, String errorMessage) {
        logger.info("[Base Page] Verifying condition is true");
        Assert.assertTrue(condition, errorMessage);
    }

    @Step("Verify False Condition: {condition}")
    public void verifyFalse(boolean condition, String errorMessage) {
        logger.info("[Base Page] Verifying condition is false");
        Assert.assertFalse(condition, errorMessage);
    }

    @Step("Verify Equals Actual: {actual}, Expected: {expected}")
    public void verifyEquals(Object actual, Object expected, String errorMessage) {
        logger.info("[Base Page] Verifying equality. Expected: {}, Actual: {}", expected, actual);
        Assert.assertEquals(actual, expected, errorMessage);
    }
}
