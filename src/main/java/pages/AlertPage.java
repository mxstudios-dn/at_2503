package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import core.BasePage;
import io.qameta.allure.Step;

class AlertPageSelector {
    public static final By btnAlertWithOK = By.id("OKTab");
    public static final By btnAlertWithOKCancel = By.id("CancelTab");
    public static final By txtMessageCancelTab = By.xpath("//div[@id='CancelTab']/p");
    public static final By tabAlertWithOKCancel = By.xpath("//a[@href='#CancelTab']");
    public static final By tabAlertWithTextbox = By.xpath("//a[@href='#Textbox']");
}

public class AlertPage extends BasePage {
    public void acceptAlert() {
        logger.info("[Alert Page]: Accepting alert");
        Alert alert = switchToAlert();
        acceptAlertAction(alert);
    }

    @Step("Dismiss alert")
    public void dismissAlert() {
        logger.info("[Alert Page]: Dismissing alert");
        Alert alert = switchToAlert();
        dismissAlertAction(alert);
    }

    @Step("Select Alert tab: {tabName}")
    public void selectAlertTab(String tabName) {
        logger.info("[Alert Page]: Selecting alert tab: {}", tabName);
        if (tabName.equals("Alert with OK & Cancel")) {
            clickElement(AlertPageSelector.tabAlertWithOKCancel);
        } else if (tabName.equals("Alert with Textbox")) {
            clickElement(AlertPageSelector.tabAlertWithTextbox);
        }
    }

    @Step("Click Alert with OK button")
    public void clickAlertWithOKButton() {
        logger.info("[Alert Page]: Clicking 'Alert with OK' button");
        clickElement(AlertPageSelector.btnAlertWithOK);
    }

    @Step("Click Alert with OK & Cancel button")
    public void clickAlertWithOKCancelButton() {
        logger.info("[Alert Page]: Clicking 'Alert with OK & Cancel' button");
        clickElement(AlertPageSelector.btnAlertWithOKCancel);
    }
    
    @Step("Get alert dismissed message")
    public String getAlertDismissedMessage() {
        logger.info("[Alert Page]: Verifying alert dismissed message");
        return getElementText(AlertPageSelector.txtMessageCancelTab);
    }
}
