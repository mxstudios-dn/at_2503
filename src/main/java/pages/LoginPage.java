package pages;

import org.openqa.selenium.By;

import core.BasePage;

class LoginPageSelector {
    public static final By BTN_REGISTER = By.cssSelector("a[href='Register.html']");
    public static final By TXT_EMAIL = By.id("email");
}

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    public RegisterPage openRegisterPage() {
        logger.info("[LoginPage]: Clicking on Register button to open Register Page");
        clickElement(LoginPageSelector.BTN_REGISTER);
        waitForElementInvisible(LoginPageSelector.TXT_EMAIL);
        return new RegisterPage();
    }

}
