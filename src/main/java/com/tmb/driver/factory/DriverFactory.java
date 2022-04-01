package com.tmb.driver.factory;

import com.tmb.driver.entity.DriverData;
import com.tmb.driver.factory.mobile.local.LocalMobileDriverFactory;
import com.tmb.driver.factory.mobile.remote.RemoteMobileDriverFactory;
import com.tmb.driver.factory.web.local.LocalDriverFactory;
import com.tmb.driver.factory.web.remote.RemoteDriverFactory;
import com.tmb.enums.RunModeType;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriverForWeb(DriverData driverData){
        if(driverData.getRunModeType() == RunModeType.LOCAL){
           return LocalDriverFactory.getDriver(driverData.getBrowserType());
        } else {
            return RemoteDriverFactory.getDriver(driverData.getBrowserRemoteModeType()
            ,driverData.getBrowserType());
        }
    }
    public static WebDriver getDriverForMobile(DriverData driverData){
        if(driverData.getRunModeType() == RunModeType.LOCAL){
            return LocalMobileDriverFactory.getDriver(driverData.getMobilePlatformType());
        } else {
            return RemoteMobileDriverFactory.getDriver(driverData.getMobileRemoteModeType()
                    ,driverData.getMobilePlatformType());
        }
    }
}
