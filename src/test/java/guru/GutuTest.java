package guru;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import pages.guru.LoginPage;

public class GutuTest extends BaseTest {

    @Test
    public void tc01() {
        /**
         * Test case sample 01
         */
        LoginPage loginPage = new LoginPage(driverManager);
        logger.info("Test case sample 01");

        logger.info("Step 1: Go to Guru99 Demo Site");
        loginPage.openGuru99DemoSite();

        logger.info("Step 2: Input blank into User Id text box");
        loginPage.enterEmailID("");
        loginPage.submitEmailID();

        logger.info("Step 3: Verify that the Login page show text as 'Email ID must not be blank'");
        loginPage.verifyLoginErrorMessage("Email ID must not be blank");
    }
}
