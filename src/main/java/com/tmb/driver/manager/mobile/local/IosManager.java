package com.tmb.driver.manager.mobile.local;

import com.tmb.config.factory.ConfigFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebDriver;

public final class IosManager {

  private IosManager() {
  }

  public static WebDriver getDriver() {
    XCUITestOptions options = new XCUITestOptions();
    options.setDeviceName("iPhone 13 Pro Max")
      .setApp(System.getProperty("user.dir") + "/ios-app.zip");
    return new IOSDriver(ConfigFactory.getConfig().localAppiumServerURL(), options);
  }
}
