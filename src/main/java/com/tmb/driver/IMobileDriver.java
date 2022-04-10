package com.tmb.driver;

import com.tmb.driver.entity.MobileDriverData;
import com.tmb.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public interface IMobileDriver {
    WebDriver getDriver(MobileDriverData driverData);
}
