package com.tmb.pages.mobile;

import com.tmb.driver.DriverManager;
import com.tmb.pages.mobile.enums.ViewsScreenMenuItemType;
import com.tmb.utils.PageActionsHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ViewsScreen {

  public ViewsScreen() {
    PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
  }

  @iOSXCUITFindBy(xpath = "")
  @AndroidFindBy(accessibility = "WebView")
  private MobileElement textboxEmail;

  private static final String VIEW_SCREEN_ELEMENT = "%s";

  public void clickOnViewScreenElement(ViewsScreenMenuItemType element) {
    By accessibilityId = MobileBy.AccessibilityId(String.format(VIEW_SCREEN_ELEMENT, element.getName()));
    PageActionsHelper.scrollForMobile(textboxEmail);
    PageActionsHelper.waitAndClick(accessibilityId);
  }

}
