package com.tmb.tests.mobile;

import com.tmb.pages.mobile.HomeScreen;
import com.tmb.tests.mobile.base.AndroidSetup;
import org.testng.annotations.Test;

public class AndroidTest extends AndroidSetup {

    @Test
    public void testLoginAndroid() {
        HomeScreen.getHomeScreenInstance()
                .navigateToViewsScreen()
                .clickViewScreenElement("WebView");
    }
}
