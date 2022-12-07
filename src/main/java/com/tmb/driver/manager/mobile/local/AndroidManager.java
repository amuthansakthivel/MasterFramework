package com.tmb.driver.manager.mobile.local;

import com.tmb.config.factory.ConfigFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public final class AndroidManager {

  private AndroidManager() {
  }

  public static WebDriver getDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
    capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/android-app.apk");
    return new AndroidDriver<AndroidElement>(ConfigFactory.getConfig().localAppiumServerURL(), capabilities);
  }
}
