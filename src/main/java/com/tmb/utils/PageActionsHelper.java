package com.tmb.utils;

import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.function.Consumer;

public class PageActionsHelper {

    private PageActionsHelper(){}

    public static void waitAndClick(By by){
        //wait strategy
        DriverManager.getDriver().findElement(by).click();
    }

    public static void waitAndSendKeys(By by, String value){
        //wait strategy
        DriverManager.getDriver().findElement(by).sendKeys(value);
    }

    public static void select(By by, Consumer<Select> consumer){
        consumer.accept(new Select(DriverManager.getDriver().findElement(by)));
    }
}
