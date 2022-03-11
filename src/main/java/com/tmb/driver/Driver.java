package com.tmb.driver;

import com.tmb.config.factory.ConfigFactory;
import com.tmb.driver.factory.web.local.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

public final class Driver {

    private Driver(){}

    public static void initDriver(){ //LocalDriverFactory
        WebDriver driver = LocalDriverFactory.getDriver(ConfigFactory.getConfig()
                .browser());
        driver.get("https://google.co.in");
    }
    public static void quitDriver(){
        /*

         */
    }
}
