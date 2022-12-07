package com.tmb.driver.factory.web.remote;

import com.tmb.enums.BrowserRemoteModeType;
import com.tmb.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public final class RemoteDriverFactory {

  private RemoteDriverFactory() {
  }

  private static final Map<BrowserRemoteModeType, Function<BrowserType, WebDriver>> MAP =
    new EnumMap<>(BrowserRemoteModeType.class);

  static {
    MAP.put(BrowserRemoteModeType.SELENIUM, SeleniumGridFactory::getDriver);
    MAP.put(BrowserRemoteModeType.SELENOID, SelenoidFactory::getDriver);
    MAP.put(BrowserRemoteModeType.BROWSER_STACK, BrowserStackFactory::getDriver);
  }

  public static WebDriver getDriver(BrowserRemoteModeType browserRemoteModeType,
                                    BrowserType browserType) {
    return MAP.get(browserRemoteModeType).apply(browserType);
  }
}
