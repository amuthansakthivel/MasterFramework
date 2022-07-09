package com.tmb.tests.web;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.tmb.fixtures.addusers.entity.UserData;
import com.tmb.pages.LoginPage;
import com.tmb.pages.pagecomponents.adduserspage.AddUserComponent;
import com.tmb.tests.web.base.WebBase;
import io.github.sskorol.core.DataSupplier;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class AddUsersTest extends WebBase {

    @DataSupplier(runInParallel = true)
    public Stream<AddUsersScenarioType> getData() {
        FixtureFactoryLoader.loadTemplates("com.tmb.fixtures");
        return Stream.of(AddUsersScenarioType.values());
    }

    @Test(dataProvider = "getData")
    public void testAddUsers(AddUsersScenarioType addUsersScenarioType) {
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
