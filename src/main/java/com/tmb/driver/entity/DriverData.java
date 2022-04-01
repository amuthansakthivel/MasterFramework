package com.tmb.driver.entity;

import com.tmb.enums.*;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DriverData {

    private BrowserType browserType;
    private BrowserRemoteModeType browserRemoteModeType;
    private MobilePlatformType mobilePlatformType;
    private RunModeType runModeType;
    private MobileRemoteModeType mobileRemoteModeType;

}
