package core;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Helper;

public class BasePage extends Helper {
    WebDriver driver;

    public BasePage() {
        super();
        this.driver = DriverManager.getDriver();
    }

    public void navigateTo(String url) {
        if (url == null) {
            throw new IllegalArgumentException("URL cannot be null");
        }
        logger.info("Navigating to URL: {}", url);
        driver.get(url);
    }


    private WebElement findElement(By selector) {
        return getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    protected boolean isElementDisplayed(By selector) {
        try {
            return findElement(selector).isDisplayed();
        } catch (Exception e) {
            logger.warn("Element {} is not displayed: {}", selector, e.getMessage());
            return false;
        }
    }
    
    public WebDriverWait getWait(long waitTime) {
        return new WebDriverWait(this.driver, Duration.ofSeconds(waitTime));
    }

    protected void waitForElementInvisible(By selector) {
        getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    private WebElement waitForElementClickable(By selector) {
        return getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.elementToBeClickable(selector));
    }

    protected void enterText(By selector, String text) {
        logger.info("Entering text {}", text);
        findElement(selector).sendKeys(text);
    }

    protected void enterTextWithoutWait(By selector, String text) {
        logger.info("Entering text {}", text);
        this.driver.findElement(selector).sendKeys(text);
    }

    protected String getElementAttribute(By selector, String attributeName) {
        logger.info("Getting attribute {} from element {}", attributeName, selector);
        return findElement(selector).getDomAttribute(attributeName);
    }

   protected String getElementValue(By selector) {
       logger.info("Getting value from element {}", selector);
       WebElement element = findElement(selector);
       return element.getText().isEmpty() ? element.getDomProperty("value") : element.getText();
   }

    protected void clickElement(By selector) {
        logger.info("Clicking element {}", selector);
        waitForElementClickable(selector).click();
    }

    protected void executeJavaScript(String script) {
        logger.info("Executing JavaScript: {}", script);
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript(script);
    }

    protected String getElementText(By selector) {
        String text = findElement(selector).getText();
        logger.info("Retrieved text '{}' from element {}", text, selector);
        return text;
    }

}
