package com.tmb.driver.manager.mobile.local;

import com.tmb.config.factory.ConfigFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;

public final class AndroidManager {

  private AndroidManager() {
  }

  public static WebDriver getDriver() {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setApp(System.getProperty("user.dir") + "/android-app.apk");
    return new AndroidDriver(ConfigFactory.getConfig().localAppiumServerURL(), options);
  }
}
