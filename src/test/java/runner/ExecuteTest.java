package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/features/"}, glue = "stepDefinitions")
public class ExecuteTest extends AbstractTestNGCucumberTests {
}
