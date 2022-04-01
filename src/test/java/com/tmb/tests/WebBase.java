package com.tmb.tests;

import com.tmb.driver.Driver;
import org.testng.annotations.BeforeMethod;

public class WebBase {


    @BeforeMethod
    public void setUp(){
        Driver.initDriverForWeb();
    }
}
