package com.tmb.tests.web;

import br.com.six2six.fixturefactory.Fixture;
import com.tmb.fixtures.addusers.entity.UserData;
import com.tmb.pages.pagecomponents.adduserspage.AddUserComponent;
import lombok.Getter;

import java.util.function.BiPredicate;

@Getter
public enum AddUsersScenarioType {

    VALID(AddUsersPredicateFactory.getPredicate("valid") , Fixture.from(UserData.class).gimme("valid")) ,

    JUST_EMPLOYEE_NAME(AddUsersPredicateFactory.getPredicate("just_employeename")
            , Fixture.from(UserData.class).gimme("just_employeename"));

    private final BiPredicate<UserData, AddUserComponent> predicate;
    private final UserData userData;

    AddUsersScenarioType(BiPredicate<UserData, AddUserComponent> predicate, UserData userData) {
        this.predicate = predicate;
        this.userData = userData;
    }
}
