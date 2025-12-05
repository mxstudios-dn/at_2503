package applitools;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import core.BaseTest;
import pages.applitools.*;

public class AppliToolTest extends BaseTest {
    @Test
    @Tag("applitools")
    public void altTc01() {
        /**
         * Test case sample 01
         */
        LoginPage loginPage = new LoginPage();
        logger.info("Test case sample 01");

        logger.info("Step 1: Go to Applitools Demo Site");
        loginPage.openSite();

        logger.info("Step 2: Login with valid email and password");
        loginPage.login("validEmail@example.com", "validPassword");

        logger.info("Step 3: Verify successful login");
        // Add verification steps here
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.verifyDashboardPageLoaded();
    }
}
