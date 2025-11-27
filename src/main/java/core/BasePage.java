package core;

import utils.Helper;

public class BasePage extends Helper {
    protected DriverManager driverBase;

    public BasePage(DriverManager driverBase) {
        this.driverBase = driverBase;
        logger.debug("{} initialized", this.getClass().getSimpleName());
    }
}
