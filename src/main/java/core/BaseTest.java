package core;
import utils.Helper;

public class BaseTest extends Helper {
    protected DriverManager driverBase;

    @BeforeAll  
    public void setup(TestInfo testInfo) {
        logger.info("========================================");
        logger.info("Starting test: {}", testInfo.getDisplayName());
        logger.info("Test class: {}", testInfo.getTestClass().orElse(null));
        logger.info("Environment: {}", getEnv("ENV"));
        logger.info("========================================");

        try {
            driverBase = new DriverManager();
            logger.debug("SeleniumDriverBase instance created");
        } catch (Exception e) {
            logger.error("Failed to initialize test setup", e);
            throw e;
        }
    }

    @AfterAll
    public void teardown(TestInfo testInfo) {
        try {
            if (driverBase != null) {
                driverBase.quit();
                logger.debug("WebDriver quit successfully");
            }
        } catch (Exception e) {
            logger.error("Error during test teardown", e);
        }

        logger.info("Test completed: {}", testInfo.getDisplayName());
        logger.info("========================================\n");
    }
}
