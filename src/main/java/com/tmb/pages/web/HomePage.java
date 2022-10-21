package com.tmb.pages.web;

import com.tmb.pages.web.topmenucomponent.MenuType;
import com.tmb.pages.web.topmenucomponent.SubMenuType;
import com.tmb.pages.web.pagecomponents.homepage.TopMenuComponent;
import com.tmb.pages.web.validator.HomePageValidator;
import com.tmb.utils.PageActionsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final TopMenuComponent topMenuComponent;
    private static final By HEADER = By.xpath("//h1");

    public HomePage(){
        this.topMenuComponent = new TopMenuComponent();
    }

    public SystemUserPage navigateToSystemUsersPage(){
        topMenuComponent.clickMenuItem(MenuType.ADMIN)
                .clickSubMenuItem(SubMenuType.USER_MANAGEMENT)
                .clickSubMenuItem(SubMenuType.USERS);
        return new SystemUserPage();
    }

    public HomePageValidator getHomePageValidator(){
        return HomePageValidator.builder()
                .isMarketplaceLinkPresent(topMenuComponent.isMarketPlaceLinkPresent())
                .logoSourceText(topMenuComponent.getLogoSourceString())
                .headerName(PageActionsHelper.getAttribute(HEADER, WebElement::getText))
                .build();
    }
}
