package com.tmb.driver.manager.web.remote.selenoid;

import com.tmb.config.factory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SelenoidFirefoxManager {

  private SelenoidFirefoxManager() {
  }

  public static WebDriver getDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName", "firefox");
    capabilities.setCapability("browserVersion", "91.0");
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", false);
    return new RemoteWebDriver(ConfigFactory.getConfig()
                                 .selenoidURL(), capabilities);
  }
}
