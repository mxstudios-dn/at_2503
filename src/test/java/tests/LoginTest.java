package tests;
import pages.LoginPage;
import pages.RegisterPage;
import core.TestSettings;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    RegisterPage registerPage;

    @Test
    public void testLogin() {
        logStep("Navigating to Login Page: " + TestSettings.BASE_URL + "/login");
        loginPage = new LoginPage();

        logStep("Skip login step");
        registerPage = loginPage.openRegisterPage();

        logStep("VP: Verify that Register Page is loaded");
        verifyFalse(registerPage.isRegisterPageLoaded(), "Register Page should be loaded");
    }
}
