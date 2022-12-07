package com.tmb.driver.manager.mobile.remote.browserstack;

import com.tmb.config.factory.BrowserStackConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class BrowserStackIosManager {

  private BrowserStackIosManager() {
  }

  public static WebDriver getDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
    capabilities.setCapability("device", "IOS Device");
    capabilities.setCapability("os_version", "9.0");
    capabilities.setCapability("project", "First Java Project");
    capabilities.setCapability("build", "browserstack-build-1");
    capabilities.setCapability("name", "first_test");
    return new RemoteWebDriver(BrowserStackConfigFactory.getConfig()
                                 .browserStackURL(), capabilities);
  }
}
