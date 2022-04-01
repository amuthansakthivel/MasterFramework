package com.tmb.driver;

import com.tmb.driver.entity.DriverData;
import com.tmb.driver.factory.DriverFactory;
import com.tmb.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

import static com.tmb.config.factory.ConfigFactory.*;

public final class Driver {

    private Driver(){}
    //local web , remote web, local mobile , remote mobile

    public static void initDriverForWeb(){
        DriverData driverData = DriverData.builder()
                .browserType(getConfig().browser())
                .browserRemoteModeType(getConfig().browserRemoteMode())
                .runModeType(getConfig().browserRunMode())
                .build();
        WebDriver driver = DriverFactory.getDriverForWeb(driverData);
        driver.quit();
    }
    public static void initDriverForMobile(){
        DriverData driverData = DriverData.builder()
                .mobilePlatformType(MobilePlatformType.ANDROID)
                .mobileRemoteModeType(getConfig().mobileRemoteMode())
                .runModeType(getConfig().mobileRunMode())
                .build();
        WebDriver driver = DriverFactory.getDriverForMobile(driverData);
        driver.quit();
    }
    public static void quitDriver(){
        /*

         */
    }
}
