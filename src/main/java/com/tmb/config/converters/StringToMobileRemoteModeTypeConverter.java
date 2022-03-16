package com.tmb.config.converters;

import com.tmb.enums.MobileRemoteModeType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToMobileRemoteModeTypeConverter implements Converter<MobileRemoteModeType> {
    @Override
    public MobileRemoteModeType convert(Method method, String mobileRemoteMode) {
        return MobileRemoteModeType.valueOf(mobileRemoteMode.toUpperCase());
    }
}
