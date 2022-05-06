package com.tmb.pages;

import com.tmb.pages.enums.topmenucomponent.MenuType;
import com.tmb.pages.enums.topmenucomponent.SubMenuType;
import com.tmb.pages.pagecomponents.homepage.TopMenuComponent;

public class HomePage {

    private TopMenuComponent topMenuComponent;

    public HomePage(){
        this.topMenuComponent = new TopMenuComponent();
    }

    public TopMenuComponent getTopMenuComponent() {
        return topMenuComponent;
    }

    public SystemUserPage navigateToSystemUsersPage(){
        topMenuComponent.clickMenuItem(MenuType.ADMIN)
                .clickSubMenuItem(SubMenuType.USER_MANAGEMENT)
                .clickSubMenuItem(SubMenuType.USERS);
        return new SystemUserPage();
    }
}
