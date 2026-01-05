package step_definitions;
import core.BasePage;
import core.TestSettings;
import io.cucumber.java.en.Given;

public class AutomationDemoSiteSteps extends BasePage {
    
    @Given("User is on the Automation demo page")
    public void navigateToAutomationDemoSite(){
        // Navigate to Automation Demo Site
        String url = TestSettings.BASE_URL;
        if (url != null) {
            navigateTo(TestSettings.BASE_URL);
        }
    }

    @Given("User navigates to the {string} page")
    public void triggerSimpleAlert(String pageName) {
        switch (pageName) {
            case "Alert":
                navigateTo(TestSettings.AUTOMATION_DEMO_ALERTS_URL);
                break;
            case "Date Picker":
                navigateTo(TestSettings.AUTOMATION_DEMO_DATE_PICKER_URL);
                break;
            default:
                navigateTo(TestSettings.AUTOMATION_DEMO_LOGIN_URL);
        }
    }
    
}
