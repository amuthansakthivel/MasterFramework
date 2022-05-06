package com.tmb.fixtures.addusers;

import br.com.six2six.fixturefactory.Fixture;
import com.tmb.fixtures.addusers.entity.UserData;
import com.tmb.fixtures.addusers.factory.AddUsersPredicateFactory;
import com.tmb.pages.pagecomponents.adduserspage.AddUserComponent;
import lombok.ToString;

import java.util.function.BiPredicate;

@ToString
public enum AddUsersScenarioType {

    VALID(AddUsersPredicateFactory.getPredicate("valid"),
            Fixture.from(UserData.class).gimme("valid"),
            "Error message"),
    INVALID_USERNAME(AddUsersPredicateFactory.getPredicate("just_username"),
            Fixture.from(UserData.class).gimme("just_username"),
            "Error message");

    private final BiPredicate<AddUserComponent, UserData> predicate;
    private final UserData userData;
    private final String errorMessage;

    public BiPredicate<AddUserComponent, UserData> getPredicate() {
        return predicate;
    }

    public UserData getUserData() {
        return userData;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    AddUsersScenarioType(BiPredicate<AddUserComponent, UserData> predicate, UserData userData, String errorMessage) {
        this.predicate = predicate;
        this.userData = userData;
        this.errorMessage = errorMessage;
    }
}
