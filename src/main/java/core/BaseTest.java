package core;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;
import utils.Helper;

public class BaseTest extends Helper {
    protected static DriverManager driverManager;

    @BeforeAll
    public static void setup(TestInfo testInfo) {
        logger.info("========================================");
        logger.info("Starting test: {}", testInfo.getDisplayName());
        logger.info("Test class: {}", testInfo.getTestClass().orElse(null));
        // logger.info("Environment: {}", getEnv("ENV"));
        logger.info("========================================");

        try {
            driverManager = new DriverManager();
            driverManager.navigateTo(TestSettings.BASE_URL);
            logger.debug("SeleniumDriverBase instance created");
        } catch (Exception e) {
            logger.error("Failed to initialize test setup", e);
            throw e;
        }
    }

    @AfterAll
    public static void teardown(TestInfo testInfo) {
        try {
            if (driverManager != null) {
                driverManager.quit();
                logger.debug("WebDriver quit successfully");
            }
        } catch (Exception e) {
            logger.error("Error during test teardown", e);
        }

        logger.info("Test completed: {}", testInfo.getDisplayName());
        logger.info("========================================\n");
    }
}
