package com.tmb.config.converters;

import com.tmb.enums.BrowserRemoteModeType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToRemoteModeBrowserTypeConverter implements Converter<BrowserRemoteModeType> {
  @Override
  public BrowserRemoteModeType convert(Method method, String remoteMode) {
    return BrowserRemoteModeType.valueOf(remoteMode.toUpperCase());
  }
}
