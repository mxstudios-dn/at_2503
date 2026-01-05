package step_definitions;

import io.cucumber.java.*;
import core.BasePage;
import core.DriverManager;


public class CucumberHooks extends BasePage {

    @Before()
    public void setUp() {
        // Code to run before each scenario
        logger.info("[Cucumber Hooks] Before scenario hook executed.");
        // Launch browser
        try {
            new DriverManager();
        } catch (Exception e) {
            logger.error("Failed to initialize DriverManager: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @After()
    public void tearDown(Scenario scenario) {
        // Code to run after each scenario
        logger.info("[Cucumber Hooks] After scenario hook executed.");
        
        // Check if scenario failed and capture screenshot
        if (scenario.isFailed()) {
            logger.error("Test Failed: " + scenario.getName());
            if (DriverManager.getDriver() != null) {
                captureScreenshot(scenario.getName() + "_onTestFailure");
            }
        }
        DriverManager.quit();
    }

    @BeforeStep()
    public void beforeStep(Scenario scenario) {
        // Code to run before each step
        logger.info("[Cucumber Hooks] Before step hook executed. ["+ scenario.getName()+"]");
    }

    @AfterStep()
    public void afterStep(Scenario scenario) {
        // Code to run after each step
        logger.info("[Cucumber Hooks] After step hook executed. ["+ scenario.getName()+"]");  
        logger.info("[Cucumber Hooks] Scenario status: [" + scenario.getStatus().toString() + "]");
    }

    @BeforeAll()
    public static void beforeAll() {
        // Code to run once before all scenarios
        System.out.println("[Cucumber Hooks] Before all scenarios hook executed.");
    }

    // @AfterAll
    // public static void afterAll() {
    //     // Code to run once after all scenarios
    //     logger.info("[Cucumber Hooks] After all scenarios hook executed.");
    //     DriverManager.quitDriver();
    // }

}