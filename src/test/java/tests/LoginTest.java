package tests;
import pages.LoginPage;
import pages.RegisterPage;
import core.TestSettings;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    RegisterPage registerPage;

    @Test
    @Description("Verify that user can navigate to Register Page from Login Page")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Minh Pham")
    public void testLogin() {
        logStep("1. Navigating to Login Page: " + TestSettings.BASE_URL + "/login");
        loginPage = new LoginPage();

        logStep("2. Skip login step");
        registerPage = loginPage.openRegisterPage();

        logStep("VP: Verify that Register Page is loaded");
        verifyTrue(registerPage.isRegisterPageLoaded(), "Register Page should be loaded");
    }
}
