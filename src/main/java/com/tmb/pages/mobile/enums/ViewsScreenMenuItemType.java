package com.tmb.pages.mobile.enums;

public enum ViewsScreenMenuItemType {
  WEB_VIEW("WebView"),
  WEB_VIEW_2("WebView2"),
  TEXT_SWITCHER("TextSwitcher"),
  TABS("Tabs");

  private final String name;

  public String getName() {
    return name;
  }

  ViewsScreenMenuItemType(String name) {
    this.name = name;
  }
}
