package com.tmb.tests.mobile;

import com.tmb.pages.mobile.HomeScreen;
import com.tmb.tests.mobile.base.AndroidSetup;
import org.junit.jupiter.api.Test;

import static com.tmb.pages.mobile.enums.ViewsScreenMenuItemType.*;

class AndroidTest extends AndroidSetup {

    /*
    Please refer mobile test
     */

    @Test
    void testLoginAndroid() {
        HomeScreen.getHomeScreenInstance()
                .navigateToViewsScreen()
                .clickOnViewScreenElement(WEB_VIEW);
        //assertion
    }
}
