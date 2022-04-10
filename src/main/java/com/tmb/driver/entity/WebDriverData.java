package com.tmb.driver.entity;

import com.tmb.enums.BrowserRemoteModeType;
import com.tmb.enums.BrowserType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WebDriverData {
    private BrowserType browserType;
    private BrowserRemoteModeType browserRemoteModeType;
}
