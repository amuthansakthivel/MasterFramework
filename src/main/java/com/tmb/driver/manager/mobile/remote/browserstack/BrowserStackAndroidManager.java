package com.tmb.driver.manager.mobile.remote.browserstack;

import com.tmb.config.factory.BrowserStackConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class BrowserStackAndroidManager {

  private BrowserStackAndroidManager() {
  }

  public static WebDriver getDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("app", "bs://067b3d9696fb162c26cd37417fa5cf1a64cdcc87");
    capabilities.setCapability("device", "Google Pixel 3");
    capabilities.setCapability("os_version", "9.0");
    capabilities.setCapability("project", "First Java Project");
    capabilities.setCapability("build", "browserstack-build-1");
    capabilities.setCapability("name", "first_test");
    return new RemoteWebDriver(BrowserStackConfigFactory.getConfig()
                                 .browserStackURL(), capabilities);
  }
}
