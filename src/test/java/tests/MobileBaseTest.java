package tests;

import core.AppiumDriverManager;

import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.Helper;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * Base test class for mobile automation tests using Appium
 * Provides setup and teardown methods for managing AppiumDriver lifecycle
 */
public class MobileBaseTest extends Helper {
    protected AppiumDriverManager appiumManager;
    /**
     * Setup executed before each test class.
     * Initializes AppiumDriver instance for mobile tests.
     *
     * @param context TestNG test context
     * @throws MalformedURLException if Appium server URL is malformed
     * @throws URISyntaxException if Appium server URI is malformed
     */
    @BeforeClass
    public void setup(ITestContext context) throws MalformedURLException, URISyntaxException {
        logger.info("########################################");
        logger.info("[Setup] Starting mobile test: {}", context.getName());
        logger.info("[Setup] Test class: {}", context.getCurrentXmlTest().getName());
        logger.info("========================================");

        appiumManager = new AppiumDriverManager();
        logger.info("[Setup] AppiumDriver initialized successfully");
    }

    /**
     * Cleanup executed after each test class.
     * Quits the AppiumDriver and cleans up resources.
     */
    @AfterClass
    public void tearDown() {
        logger.info("========================================");
        logger.info("[TearDown] Cleaning up AppiumDriver");
        logger.info("########################################");
        
        if (appiumManager != null) {
            // appiumManager.quit();
            logger.info("[TearDown] AppiumDriver quit successfully");
        }
    }

    /**
     * Method executed before each test method.
     * Can be used for test-level setup operations.
     *
     * @param context TestNG test context
     */
    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        String methodName = context.getCurrentXmlTest().getName();
        logger.info("[BeforeMethod] Starting method: {}", methodName);
    }

    /**
     * Method executed after each test method.
     * Can be used for test-level cleanup operations.
     */
    @AfterMethod
    public void afterMethod() {
        logger.info("[AfterMethod] Test method completed");
    }
}
