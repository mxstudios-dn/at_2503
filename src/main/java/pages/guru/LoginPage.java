package pages.guru;

import core.BasePage;
import org.openqa.selenium.By;


class LoginPageSelector {
    public static final By txtUsernameId = By.name("emailid");
    public static final By btnSubmit = By.name("btnLogin");
    public static final By lblEmailMessage = By.xpath("//td[input[@name='emailid']]/label");
}

public class LoginPage extends BasePage {

    public void enterEmailID(String email) {
        logger.info("Entering email ID: {}", email);
        enterText(LoginPageSelector.txtUsernameId, email);
    }

    public void submitEmailID() {
        logger.info("Login Page: Submitting email ID");
        clickButton(LoginPageSelector.btnSubmit);
    }

    public void verifyLoginErrorMessage(String msg){
        logger.info("Login Page: Verifying login error message: {}", msg);
        String crrMsg = getElementText(LoginPageSelector.lblEmailMessage);
        verifyTrue(crrMsg.equals(msg), String.format("Expected login error message: '%s', but found: '%s'", msg, crrMsg));
    }
}
