package com.tmb.tests.web;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.tmb.fixtures.addusers.entity.UserData;
import com.tmb.pages.LoginPage;
import com.tmb.pages.pagecomponents.adduserspage.AddUserComponent;
import com.tmb.tests.web.base.WebBase;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.BiPredicate;

public class AddUsersTest extends WebBase {

    BiPredicate<UserData, AddUserComponent> justEmployeeNamePredicate = (userData, addUserComponent) -> {
        addUserComponent.setEmployeeNameTextBox(userData.getEmployeeName());
        return addUserComponent.isErrorDisplayedForEmployeeName();
    };

    BiPredicate<UserData, AddUserComponent> validPredicate = (userData, addUserComponent) -> {
        addUserComponent.setUserRoleDropDown(userData.getUserRole())
                .setUserNameTextBox(userData.getUserName())
                .setPasswordTextBox(userData.getPassword())
                .setConfirmPasswordTextBox(userData.getPassword())
                .setStatusDropDown(userData.getStatus())
                .setEmployeeNameTextBox(userData.getEmployeeName());
        return addUserComponent.isSuccessMessageDisplayed();
    };



    @DataProvider
    public Object[][] getData() {
        FixtureFactoryLoader.loadTemplates("com.tmb.fixtures");

        UserData valid = Fixture.from(UserData.class).gimme("valid");
        UserData justEmployeeName = Fixture.from(UserData.class).gimme("just_employeename");

        return new Object[][]{
                {valid, validPredicate},
                {justEmployeeName, justEmployeeNamePredicate}
        };
    }

    @Test(dataProvider = "getData")
    public void testAddUsers(UserData userData, BiPredicate<UserData, AddUserComponent> predicate) {
        boolean isMessageDisplayed = new LoginPage()
                .loginToApplication("Admin", "admin123")
                .navigateToSystemUsersPage()
                .getUserListComponent()
                .setAddButton()
                .fillDetails(userData, predicate);

        Assertions.assertThat(isMessageDisplayed)
                .withFailMessage(()->"Success message in the field is not displayed")
                .isTrue();
    }


}
