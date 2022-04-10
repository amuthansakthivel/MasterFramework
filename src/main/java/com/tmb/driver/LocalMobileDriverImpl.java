package com.tmb.driver;

import com.tmb.driver.entity.MobileDriverData;
import com.tmb.driver.entity.WebDriverData;
import com.tmb.driver.factory.mobile.local.LocalMobileDriverFactory;
import com.tmb.driver.factory.web.local.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

public class LocalMobileDriverImpl implements IMobileDriver{

    @Override
    public WebDriver getDriver(MobileDriverData driverData) {
        return LocalMobileDriverFactory.getDriver(driverData.getMobilePlatformType());
    }
}
