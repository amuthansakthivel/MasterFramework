package com.tmb.driver;

import com.tmb.driver.entity.WebDriverData;
import com.tmb.driver.factory.web.local.LocalDriverFactory;
import com.tmb.driver.factory.web.remote.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;

public class RemoteWebDriverImpl implements IWebDriver{
    @Override
    public WebDriver getDriver(WebDriverData driverData) {
        return RemoteDriverFactory.getDriver(driverData.getBrowserRemoteModeType()
                ,driverData.getBrowserType());
    }
}
