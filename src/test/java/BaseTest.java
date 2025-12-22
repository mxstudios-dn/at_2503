import core.DriverManager;
import core.TestSettings;
import org.testng.ITestContext;
import org.testng.Assert;
import org.testng.annotations.*;
import core.BasePage;
import utils.Helper;
import java.net.MalformedURLException;

public class BaseTest extends Helper {
    protected DriverManager driverManager;
    protected BasePage basePage;

    /**
     * Setup executed before each test method.
     * Initializes WebDriver instance for the test.
     *
     * @param context TestNG test context
     * @throws MalformedURLException if hub URL is malformed
     */
    @BeforeClass
    public void setup(ITestContext context) throws MalformedURLException {
        logger.info("########################################");
        logger.info("[Setup] Starting test: {}", context.getName());
        logger.info("[Setup] Test class: {}", context.getCurrentXmlTest().getName());
        logger.info("[Setup] Environment: {}", TestSettings.TEST_ENV);
        logger.info("[Setup] Browser: {}", TestSettings.BROWSER_TYPE);
        logger.info("========================================");
        driverManager = new DriverManager();
        basePage = new BasePage();
        basePage.navigateTo(TestSettings.BASE_URL);
    }
    
    @BeforeTest
    public void beforeTest(ITestContext context) {
        String testName = context.getName();
        logger.info("[BeforeTest] Running test: " + testName);
    }

    @AfterClass
    public void teardown(ITestContext context){
        logger.info("========================================");
        try{
            if (driverManager != null) {
                driverManager.quit();
                logger.info("[BaseTest]: WebDriver quit successfully");
            }
        } catch(Exception e){
            logger.error("[BaseTest]: Error during test teardown", e);
        }
        logger.info("########################################");
    }
    
    // Assertion Helpers
    /**
     * Verifies that a condition is true and logs the result.
     * @param condition
     * @param message
     */
    protected void verifyTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
            logger.info("[ASSERTION PASSED] " + message);
        } catch (AssertionError e) {
            logger.error("[ASSERTION FAILED] " + message, e);
            throw e;
        }
    }

    /**
     * Verifies that a condition is false and logs the result.
     * @param condition
     * @param message
     */
    protected void verifyFalse(boolean condition, String message) {
        try {
            Assert.assertFalse(condition, message);
            logger.info("[ASSERTION PASSED] " + message);
        } catch (AssertionError e) {
            logger.error("[ASSERTION FAILED] " + message, e);
            throw e;
        }
    }

    /**
     * Verifies that two objects are equal and logs the result.
     * @param actual
     * @param expected
     * @param message
     */
    protected void verifyEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
            logger.info("[ASSERTION PASSED] " + message);
        } catch (AssertionError e) {
            logger.error("[ASSERTION FAILED] " + message, e);
            throw e;
        }
    }
}
