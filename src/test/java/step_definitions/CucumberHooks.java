package step_definitions;

import io.cucumber.java.*;
import io.qameta.allure.Allure;

import java.nio.file.Files;
import java.nio.file.Paths;

import core.BasePage;
import core.DriverManager;
import core.ShareValueManager;


public class CucumberHooks extends BasePage {

    /** 
     * Hook to run before each scenario.
     */
    @Before()
    public void setUp() {
        // Code to run before each scenario
        logger.info("[Cucumber Hooks] Before scenario hook executed.");
        ShareValueManager.clearValues();
        ShareValueManager.setValue("SCENARIO_START_TIME", String.valueOf(System.currentTimeMillis()));
        // Launch browser
        try {
            new DriverManager();
        } catch (Exception e) {
            logger.error("Failed to initialize DriverManager: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /** 
     * Hook to run after each scenario.
     * @param scenario The scenario that just ran.
     */
    @After()
    public void tearDown(Scenario scenario) {
        // Code to run after each scenario
        logger.info("[Cucumber Hooks] After scenario hook executed.");

        // Calculate and log scenario duration
        ShareValueManager.setValue("SCENARIO_END_TIME", String.valueOf(System.currentTimeMillis()));
        Long startTime = Long.parseLong(ShareValueManager.getValue("SCENARIO_START_TIME"));
        Long endTime = Long.parseLong(ShareValueManager.getValue("SCENARIO_END_TIME"));
        Long duration = (endTime - startTime) / 1000;
        logger.info("[Cucumber Hooks] Scenario '{}' executed in {} s", scenario.getName(), duration);

        // Check if scenario failed and capture screenshot
        if (scenario.isFailed()) {
            logger.error("Test Failed: " + scenario.getName());
        }
        if (DriverManager.getDriver() != null) {
            String screenshotPath = captureScreenshot(scenario.getName() + "_onTestFailure");
            
            try {
                byte[] screenshotBytes = Files.readAllBytes(Paths.get(screenshotPath));
                Allure.addAttachment("Screenshot on Failure", "image/png", new java.io.ByteArrayInputStream(screenshotBytes), "png");
            } catch (java.io.IOException e) {
                logger.error("Failed to attach screenshot to Allure report", e);
            }
        }

        // Quit browser
        DriverManager.quit();
    }

    // @BeforeAll()
    // public static void beforeAll() {
    //     // Code to run once before all scenarios
    //     System.out.println("[Cucumber Hooks] Before all scenarios hook executed.");
    // }

    // @AfterAll
    // public static void afterAll() {
    //     // Code to run once after all scenarios
    //     logger.info("[Cucumber Hooks] After all scenarios hook executed.");
    // }

}