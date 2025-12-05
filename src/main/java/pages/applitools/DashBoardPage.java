package pages.applitools;
import org.openqa.selenium.By;

import core.BasePage;

class DashBoardSelector {
    // Define selectors for Dashboard Page elements here
    public static final By icoUser = By.xpath("//div[@class='logged-user-w avatar-inline']");
    
}

public class DashBoardPage extends BasePage {
    public void verifyDashboardPageLoaded() {
        logger.info("Verifying that the Dashboard page is loaded");
        verifyElementVisible(DashBoardSelector.icoUser, "User icon is not visible on the Dashboard page");
    }
}
