package com.tmb.utils;

import com.tmb.driver.DriverManager;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
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

    public static void scrollForMobile(By by) {
        String previousPageSource = "";
        while (isElementNotEnabled(by) && isNotEndOfPage(previousPageSource)) {
            previousPageSource = DriverManager.getDriver().getPageSource();
            performScroll();
        }
    }

    public static void scrollForMobile(WebElement element) {
        String previousPageSource = "";
        while (isElementNotEnabled(element) && isNotEndOfPage(previousPageSource)) {
            previousPageSource = DriverManager.getDriver().getPageSource();
            performScroll();
        }
    }

    private static boolean isNotEndOfPage(String previousPageSource) {
        return !previousPageSource.equals(DriverManager.getDriver().getPageSource());
    }

    private static boolean isElementNotEnabled(WebElement element) {
        try{
            return !element.isDisplayed();
        }
        catch (NoSuchElementException e){
            return true;
        }
    }

    private static boolean isElementNotEnabled(By by) {
        List<WebElement> elements = DriverManager.getDriver().findElements(by);
        if (isAndroid()) {
            return elements.isEmpty();
        }
        if (!elements.isEmpty()) {
            return elements.get(0).getAttribute("visible").equalsIgnoreCase("false");
        }
        return true;
    }

    private static void performScroll() {
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startX = size.getWidth() / 2;
        int endX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endY = (int)(size.getHeight() * 0.25);

        if (isAndroid()) performScrollForAndroid(startX, startY, endX, endY);
        else performScrollForIOS(startX, startY, endX, endY);
    }

    private static void performScrollForAndroid(int startX, int startY, int endX, int endY) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    private static void performScrollForIOS(int startX, int startY, int endX, int endY) {
        new IOSTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }
}
