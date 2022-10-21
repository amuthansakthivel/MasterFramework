package com.tmb.pages.mobile;

import com.tmb.utils.PageActionsHelper;
import io.appium.java_client.MobileBy;

public class ViewsScreen {

    private static final String VIEW_SCREEN_ELEMENT = "%s";

    public void clickViewScreenElement(String elementName){
        String accessibilityId = String.format(VIEW_SCREEN_ELEMENT, elementName);
        PageActionsHelper.waitAndClick(MobileBy.AccessibilityId(accessibilityId));
    }

}