package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Helper;

public class DriverManager extends Helper {
    WebDriver driver;

    public DriverManager() {
        super();
        initializeDriver("chrome");
    }

    public DriverManager(String browserType) {
        super();
        initializeDriver(browserType);
    }

    public void initializeDriver(String browserType) {
        logger.info("Initializing {} browser", browserType);
        
        try {
            // Implementation for initializing the WebDriver
            switch (browserType) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(String.format("--window-size=%s", TestSettings.SCREEN_RESOLUTION));
                    if(TestSettings.HEADLESS){
                        options.addArguments("--headless=new");
                    }
                    this.driver = new ChromeDriver(options);
                    logger.debug("Chrome browser initialized with headless mode");
                    break;
                case "firefox":
                    this.driver = new FirefoxDriver();
                    logger.debug("Firefox browser initialized");
                     break;
                 case "edge":
                     this.driver = new EdgeDriver();
                     logger.debug("Edge browser initialized");
                      break;
                default:
                    logger.error("Unsupported browser type: {}", browserType);
                    throw new IllegalArgumentException("Unsupported browser type: " + browserType);
            }
            logger.info("WebDriver initialized successfully");
        } catch (Exception e) {
            logger.error("Failed to initialize {} browser", browserType, e);
            throw e;
        }
    }

    /**
     * Gets the WebDriver instance.
     * @return
     */
    public WebDriver getDriver() {
        if (this.driver == null) {
            logger.warn("Driver is null, returning null reference");
        }
        return this.driver;
    }

    public void navigateTo(String url) {
        logger.info("Navigating to URL: {}", url);
        try {
            this.driver.get(url);
            logger.debug("Navigation to {} successful", url);
        } catch (Exception e) {
            logger.error("Failed to navigate to URL: {}", url, e);
            throw e;
        }
    }

    /**
     * Quits the WebDriver instance, closing all associated windows.
     */
    public void quit() {
        if (this.driver != null) {
            logger.info("Quitting WebDriver");
            try {
                this.driver.quit();
                logger.debug("WebDriver quit successfully");
            } catch (Exception e) {
                logger.error("Error while quitting driver", e);
            }
        } else {
            logger.warn("Attempted to quit null driver");
        }
    }

    /**
     * Finds a web element using the specified locator.
     * @param selector The locator to find the element.
     * @return The found WebElement.
     */
    public WebElement findElement(By selector) {
        return this.driver.findElement(selector);
    }

    /**
     * Gets the title of the current page.
     * @return The page title.
     */
    public String getTitle() {
        logger.debug("Getting page title");
        return this.driver.getTitle();
    }
}

