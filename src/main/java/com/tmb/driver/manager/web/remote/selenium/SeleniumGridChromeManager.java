package com.tmb.driver.manager.web.remote.selenium;

import com.tmb.config.factory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SeleniumGridChromeManager {

  private SeleniumGridChromeManager() {
  }

  public static WebDriver getDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName(BrowserType.CHROME);
    return new RemoteWebDriver(ConfigFactory.getConfig()
                                 .seleniumGridURL(), capabilities);
  }
}
