package com.tmb.driver;

import com.tmb.driver.entity.MobileDriverData;
import com.tmb.driver.factory.mobile.local.LocalMobileDriverFactory;
import com.tmb.driver.factory.mobile.remote.RemoteMobileDriverFactory;
import org.openqa.selenium.WebDriver;

public class RemoteMobileDriverImpl implements IMobileDriver{

    @Override
    public WebDriver getDriver(MobileDriverData driverData) {
        return RemoteMobileDriverFactory.getDriver(driverData.getMobileRemoteModeType()
                ,driverData.getMobilePlatformType());
    }
}
