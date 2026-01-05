package step_definitions;

import io.cucumber.java.en.*;
import pages.AlertPage;

public class AlertSteps extends AlertPage {
    AlertPage alertPage = new AlertPage();

    @When("I click {string} button to display an alert box")
    public void alertStepsClickButton(String buttonName) {
        switch (buttonName) {
            case "Alert with OK":
                alertPage.clickAlertWithOKButton();
                break;
            case "Alert with OK & Cancel":
                alertPage.clickAlertWithOKCancelButton();
                break;
            default:
                alertPage.clickAlertWithOKButton();
        }
    }

    @When("I dismiss the alert box")
    public void alertStepsDismissAlertBox() {
        alertPage.dismissAlert();
    }

    @Then("I verify the alert display with message {string} successfully")
    public void alertStepsVerifyAlertDismissed(String expectedMessage) {
        String actMessage = alertPage.getAlertMessage();
        verifyEquals(actMessage, expectedMessage, "[Alert Steps] Alert dismissed message does not match expected value.");
    }

    @Then("I verify the alert was disappeared successfully")
    public void alertStepsVerifyAlertWasDismissed() {
        verifyTrue(isAlertDisappeared(), "[Alert Steps] Alert is still present when it should have disappeared.");
    }
}
