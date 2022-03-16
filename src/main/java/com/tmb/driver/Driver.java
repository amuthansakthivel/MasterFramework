package com.tmb.driver;

import com.tmb.driver.factory.web.local.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

import static com.tmb.config.factory.ConfigFactory.getConfig;

public final class Driver {

    private Driver(){}

    public static void initDriver(){
        WebDriver driver = LocalDriverFactory.getDriver(getConfig().browser());
        driver.get("https://google.co.in");
    }
    public static void quitDriver(){
        /*

         */
    }
}
