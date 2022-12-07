package com.tmb.driver;

import com.tmb.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public interface IWebDriver {
  WebDriver getDriver(WebDriverData driverData);
}
