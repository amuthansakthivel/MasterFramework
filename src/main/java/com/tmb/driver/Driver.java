package com.tmb.driver;

import com.tmb.driver.entity.MobileDriverData;
import com.tmb.driver.entity.WebDriverData;
import com.tmb.driver.factory.DriverFactory;
import com.tmb.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

import static com.tmb.config.factory.ConfigFactory.*;

public final class Driver {

    private Driver(){}

    public static void initDriverForWeb(){
        WebDriverData driverData = new WebDriverData(getConfig().browser(),getConfig().browserRemoteMode());

        WebDriver driver = DriverFactory
                .getDriverForWeb(getConfig().browserRunMode())
                .getDriver(driverData);
        DriverManager.setDriver(driver);

    }
    public static void initDriverForMobile(){
        MobileDriverData driverData = new MobileDriverData(MobilePlatformType.ANDROID,getConfig().mobileRemoteMode());
        WebDriver driver = DriverFactory
                .getDriverForMobile(getConfig().mobileRunMode())
                .getDriver(driverData);
        DriverManager.setDriver(driver);
    }
    public static void quitDriver(){
        DriverManager.getDriver().quit();
    }
}
