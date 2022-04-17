package com.tmb.driver.impl.mobile;

import com.tmb.driver.IMobileDriver;
import com.tmb.driver.entity.MobileDriverData;
import com.tmb.driver.factory.mobile.local.LocalMobileDriverFactory;
import org.openqa.selenium.WebDriver;

public class LocalMobileDriverImpl implements IMobileDriver {

    @Override
    public WebDriver getDriver(MobileDriverData driverData) {
        return LocalMobileDriverFactory.getDriver(driverData.getMobilePlatformType());
    }
}
