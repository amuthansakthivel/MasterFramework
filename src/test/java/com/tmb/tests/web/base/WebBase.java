package com.tmb.tests.web.base;

import com.tmb.driver.Driver;
import com.tmb.tests.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebBase extends Base {

    @BeforeMethod
    public void setUp(){
        Driver.initDriverForWeb();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
