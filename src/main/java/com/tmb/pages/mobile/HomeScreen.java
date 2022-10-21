package com.tmb.pages.mobile;

import com.tmb.utils.PageActionsHelper;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class HomeScreen {

    private static final By VIEWS_ANDROID = MobileBy.AccessibilityId("Views");
    private static final By VIEWS_IOS = By.xpath("//*[@name='Views']");

    private HomeScreen(){}

    public static HomeScreen getHomeScreenInstance(){
        return new HomeScreen();
    }

    public ViewsScreen navigateToViewsScreen(){
        PageActionsHelper.waitAndClick(VIEWS_ANDROID, VIEWS_IOS);
        return new ViewsScreen();
    }
}