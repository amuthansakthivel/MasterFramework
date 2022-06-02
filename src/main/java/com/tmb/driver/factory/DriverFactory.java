package com.tmb.driver.factory;

import com.tmb.driver.*;
import com.tmb.driver.impl.mobile.LocalMobileDriverImpl;
import com.tmb.driver.impl.mobile.RemoteMobileDriverImpl;
import com.tmb.driver.impl.web.LocalWebDriverImpl;
import com.tmb.driver.impl.web.RemoteWebDriverImpl;
import com.tmb.enums.RunModeType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {

    private DriverFactory() {
    }

    private static final Map<RunModeType, Supplier<IWebDriver>> WEB = new EnumMap<>(RunModeType.class);
    private static final Map<RunModeType, Supplier<IMobileDriver>> MOBILE = new EnumMap<>(RunModeType.class);

    static {
        WEB.put(RunModeType.LOCAL, LocalWebDriverImpl::new);
        WEB.put(RunModeType.REMOTE, RemoteWebDriverImpl::new);
        MOBILE.put(RunModeType.LOCAL, LocalMobileDriverImpl::new);
        MOBILE.put(RunModeType.REMOTE, RemoteMobileDriverImpl::new);
    }

    public static IWebDriver getDriverForWeb(RunModeType runModeType) {
        return WEB.get(runModeType).get();
    }

    public static IMobileDriver getDriverForMobile(RunModeType runModeType) {
        return MOBILE.get(runModeType).get();
    }

    // TODO: To create a runmode type for self-healing (local and remote)
}
