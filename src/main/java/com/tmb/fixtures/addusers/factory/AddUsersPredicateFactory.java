package com.tmb.fixtures.addusers.factory;

import com.tmb.fixtures.addusers.entity.UserData;
import com.tmb.pages.pagecomponents.adduserspage.AddUserComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

public final class AddUsersPredicateFactory {

    private AddUsersPredicateFactory(){}

    private static final Map<String,BiPredicate<AddUserComponent, UserData>> MAP = new HashMap<>();

    private static final BiPredicate<AddUserComponent, UserData> VALID = ((addUserComponent, addUsers) ->
            addUserComponent.setEmployeeNameTextBox(addUsers.getEmployeeName())
                    .setStatusDropDown(addUsers.getStatus())
                    .setPasswordTextBox(addUsers.getPassword())
                    .setConfirmPasswordTextBox(addUsers.getPassword())
                    .setUserNameTextBox(addUsers.getUserName())
                    .setUserRoleDropDown(addUsers.getUserRole())
                    .isSuccessMessageDisplayed());

    private static final BiPredicate<AddUserComponent, UserData> JUST_USERNAME = ((addUserComponent, addUsers) ->
            addUserComponent
                    .setUserNameTextBox(addUsers.getUserName())
                    .isSuccessMessageDisplayed());

    static {
        MAP.put("valid", VALID);
        MAP.put("just_username", JUST_USERNAME);
    }

    public static BiPredicate<AddUserComponent, UserData> getPredicate(String templateName){
        return MAP.get(templateName);
    }



}
