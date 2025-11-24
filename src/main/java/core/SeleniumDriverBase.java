package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Helper;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverBase extends Helper {
    WebDriver driver;

    public SeleniumDriverBase() {
        super();
        initializeDriver("chrome");
    }

    public SeleniumDriverBase(String browserType) {
        super();
        initializeDriver(browserType);
    }

    public void initializeDriver(String browserType) {
        // Implementation for initializing the WebDriver
        switch (browserType) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("disable-infobars");
                options.addArguments("--window-size=500,400");
                this.driver = new ChromeDriver(options);
                this.driver.manage().window().maximize();
                break;
            case "firefox":
                this.driver = new FirefoxDriver();
                 break;
             case "edge":
                 this.driver = new EdgeDriver();
                  break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}

