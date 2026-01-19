package core;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import utils.Helper;

public class AppiumManager extends Helper {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    public AppiumManager() {
        super();
    }
}
