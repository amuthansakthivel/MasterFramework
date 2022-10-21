package com.tmb.utils;

import com.tmb.driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PageActionsHelper {

    private PageActionsHelper(){}

    public static void waitAndClick(By by){
        //wait strategy
        DriverManager.getDriver().findElement(by).click();
    }

    public static void waitAndClick(By androidBy, By iosBy){
        //wait strategy
        By byBasedOnMobilePlatform = getByBasedOnMobilePlatform(androidBy, iosBy);
        DriverManager.getDriver().findElement(byBasedOnMobilePlatform).click();
    }

    public static void waitAndSendKeys(By by, String value){
        //wait strategy
        DriverManager.getDriver().findElement(by).sendKeys(value);
    }

    public static void select(By by, Consumer<Select> consumer){
        consumer.accept(new Select(DriverManager.getDriver().findElement(by)));
    }

    public static String getAttribute(By by, Function<WebElement,String> attributeFunction){
        return attributeFunction.apply(DriverManager.getDriver().findElement(by));
    }

    public static boolean isPresent(By by, Predicate<WebElement> elementPredicate){
        return elementPredicate.test(DriverManager.getDriver().findElement(by));
    }

    private static By getByBasedOnMobilePlatform(By androidBy, By iosBy){
        return isAndroid() ? androidBy : iosBy;
    }

    private static boolean isAndroid(){
        return DriverManager.getDriver() instanceof AndroidDriver;
    }

}
