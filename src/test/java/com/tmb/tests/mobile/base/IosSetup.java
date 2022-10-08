package com.tmb.tests.mobile.base;

import com.tmb.driver.Driver;
import com.tmb.enums.MobilePlatformType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class IosSetup {

    @BeforeMethod
    public void setUp(){
        Driver.initDriverForMobile(MobilePlatformType.IOS);
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}