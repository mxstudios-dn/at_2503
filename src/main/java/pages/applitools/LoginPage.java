package pages.applitools;
import org.openqa.selenium.By;
import core.BasePage;

class LoginPageSelector {
    public static final By txtUsername = By.id("username");
    public static final By txtPassword = By.id("password");
    public static final By btnSignIn = By.id("log-in");
}

public class LoginPage extends BasePage {

    public void login(String email, String password) {
        logger.info("Logging in with email: {} and password: {}", email, password);
        enterText(LoginPageSelector.txtUsername, email);
        enterText(LoginPageSelector.txtPassword, password);
        clickButton(LoginPageSelector.btnSignIn);
    }
}