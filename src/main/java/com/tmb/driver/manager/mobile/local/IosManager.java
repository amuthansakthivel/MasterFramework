package com.tmb.driver.manager.mobile.local;

import com.tmb.config.factory.ConfigFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public final class IosManager {

    private IosManager(){}

    public static WebDriver getDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.IOS);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13 Pro Max");
        capabilities.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir")+"/ios-app.zip");
        return new IOSDriver<IOSElement>(ConfigFactory.getConfig().localAppiumServerURL(),capabilities);
    }
}
