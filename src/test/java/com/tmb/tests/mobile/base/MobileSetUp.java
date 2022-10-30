package com.tmb.tests.mobile.base;

import com.tmb.config.factory.ConfigFactory;
import com.tmb.driver.Driver;
import com.tmb.enums.MobilePlatformType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class MobileSetUp {

    private final MobilePlatformType mobilePlatformType = ConfigFactory.getConfig()
            .mobilePlatformType();

    @BeforeEach
    public void setUp(){
        Driver.initDriverForMobile(mobilePlatformType);
    }

    @AfterEach
    public void tearDown(){
        Driver.quitDriver();
    }
}