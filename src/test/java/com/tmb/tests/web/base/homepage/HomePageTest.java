package com.tmb.tests.web.base.homepage;

import com.tmb.pages.LoginPage;
import com.tmb.pages.validator.HomePageValidator;
import com.tmb.tests.web.base.WebBase;
import org.junit.jupiter.api.Test;

class HomePageTest extends WebBase {

    @Test
    void testHomePageComponents(){
        HomePageValidator homepage = new LoginPage()
                .loginToApplication("Admin", "admin123")
                .getHomePageValidator();

        HomePageAssert.assertThat(homepage)
                .isMarketPlaceLinkPresent()
                .headerNameEquals("Dashboard")
                .logoSourceStringContains("/webres_62dc2eaf175ba1.37872590/themes/default/images/logo.png")
                .assertAll();
    }

}
