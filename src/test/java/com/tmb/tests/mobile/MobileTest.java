package com.tmb.tests.mobile;

import com.tmb.annotations.AndroidTest;
import com.tmb.annotations.IosTest;
import com.tmb.pages.mobile.HomeScreen;
import com.tmb.pages.mobile.IosHomeScreen;
import com.tmb.tests.mobile.base.MobileSetUp;

import static com.tmb.pages.mobile.enums.ViewsScreenMenuItemType.WEB_VIEW;

class MobileTest extends MobileSetUp {

    @AndroidTest
    void testLoginAndroid() {
        HomeScreen.getHomeScreenInstance()
                .navigateToViewsScreen()
                .clickOnViewScreenElement(WEB_VIEW);
        //assertion
    }

    @IosTest
    void testLoginIos() {
        IosHomeScreen.getInstance()
                .addANewTask();

        //add assertion
    }

    @AndroidTest
    @IosTest
    void testLoginBoth() {
        HomeScreen.getHomeScreenInstance()
                .navigateToViewsScreen()
                .clickOnViewScreenElement(WEB_VIEW);
        //assertion
    }
}