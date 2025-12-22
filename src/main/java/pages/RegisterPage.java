package pages;

import org.openqa.selenium.By;

import core.BasePage;

class RegisterPageSelector {
    public static final By LBL_REGISTER = By.xpath("//h2[text()='Register']");
}

public class RegisterPage extends BasePage {

    public RegisterPage() {
        super();
    }
    
    public boolean isRegisterPageLoaded() {
        logger.info("[RegisterPage]: Verifying that Register Page is loaded");
        return isElementDisplayed(RegisterPageSelector.LBL_REGISTER);
    }
}
