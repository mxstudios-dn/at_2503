package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerPage {
    private WebDriver driver;
    private By managerIdText = By.xpath("//td[contains(text(),'Manger Id')]");

    public ManagerPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getManagerIdText() {
        return driver.findElement(managerIdText).getText();
    }
}
