package com.tmb.config;

import com.tmb.config.converters.StringToBrowserTypeConverter;
import com.tmb.config.converters.StringToMobilePlatformTypeConverter;
import com.tmb.config.converters.StringToMobileRemoteModeTypeConverter;
import com.tmb.config.converters.StringToRemoteModeBrowserTypeConverter;
import com.tmb.config.converters.StringToRunModeBrowserTypeConverter;
import com.tmb.config.converters.StringToURLConverter;
import com.tmb.enums.BrowserRemoteModeType;
import com.tmb.enums.BrowserType;
import com.tmb.enums.MobilePlatformType;
import com.tmb.enums.MobileRemoteModeType;
import com.tmb.enums.RunModeType;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
  "system:properties",
  "system:env",
  "file:${user.dir}/src/test/resources/config.properties",
  "file:${user.dir}/src/test/resources/staging-config.properties",
  "file:${user.dir}/src/test/resources/dev-config.properties"
})
public interface FrameworkConfig extends Config {

  @DefaultValue("staging")
  String environment();

  @Key("${environment}.webUrl")
  String webUrl();

  @DefaultValue("CHROME")
  @ConverterClass(StringToBrowserTypeConverter.class)
  BrowserType browser();

  @Key("runModeBrowser")
  @ConverterClass(StringToRunModeBrowserTypeConverter.class)
  RunModeType browserRunMode();

  @Key("browserRemoteMode")
  @ConverterClass(StringToRemoteModeBrowserTypeConverter.class)
  BrowserRemoteModeType browserRemoteMode();

  @Key("runModeMobile")
  @ConverterClass(StringToRunModeBrowserTypeConverter.class)
  RunModeType mobileRunMode();

  @Key("mobileRemoteMode")
  @ConverterClass(StringToMobileRemoteModeTypeConverter.class)
  MobileRemoteModeType mobileRemoteMode();

  @ConverterClass(StringToURLConverter.class)
  URL seleniumGridURL();

  @ConverterClass(StringToURLConverter.class)
  URL selenoidURL();

  @ConverterClass(StringToURLConverter.class)
  @DefaultValue("http://127.0.0.1:4723/wd/hub")
  URL localAppiumServerURL();

  @ConverterClass(StringToMobilePlatformTypeConverter.class)
  @DefaultValue("ios")
  MobilePlatformType mobilePlatformType();
}
