package com.tmb.tests.mobile.base;

import com.tmb.driver.Driver;
import com.tmb.tests.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MobileBase extends Base {

    @BeforeMethod
    public void setUp(){
        Driver.initDriverForMobile();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
