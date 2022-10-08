package com.tmb.tests.web.base.users;

import com.tmb.pages.LoginPage;
import com.tmb.tests.web.base.WebSetup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class AddUsersTest extends WebSetup {

    @ParameterizedTest
    @EnumSource(value = AddUsersScenarioType.class,
                names = {"VALID"},
                mode = EnumSource.Mode.INCLUDE)
    void testAddUsers(AddUsersScenarioType addUsersScenarioType) {
        boolean isMessageDisplayed = new LoginPage()
                .loginToApplication("Admin", "admin123")
                .navigateToSystemUsersPage()
                .getUserListComponent()
                .setAddButton()
                .fillDetails(addUsersScenarioType.getUserData(), addUsersScenarioType.getPredicate());

        Assertions.assertThat(isMessageDisplayed)
                .withFailMessage(()->addUsersScenarioType.getUserData().getMessage())
                .isTrue();
    }
}
