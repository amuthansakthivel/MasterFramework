package com.tmb.tests.api;

import com.tmb.api.ReqresApi;
import com.tmb.api.pojos.UserDetails;
import com.tmb.api.pojos.UserResponseDetails;
import com.tmb.tests.api.assertwrapper.ResponseAssert;
import com.tmb.tests.api.testdata.UserTestData;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Predicate;

class ReqresTest {

  @Test
  void testListUsersApi() { //Intention -> Make a api call and get the response
    //AAA
    Response response = ReqresApi.getUsers();
    int actualStatusCode = response.statusCode();

    Assertions.assertThat(actualStatusCode)
      .isEqualTo(200);
    //Assertion
  }

  @Test
  void postNewUser() throws IOException {
    UserDetails userDetails = UserTestData.getUserDetails();
    Response response = ReqresApi.postUsers(userDetails);

    Predicate<Response> predicate = res -> res.jsonPath()
      .getString("job")
      .equalsIgnoreCase("leader");

    ResponseAssert.assertThat(response)
      .statusCodeIs(201)
      .canBeDeserializedTo(UserResponseDetails.class)
      .hasKeyWithValue("job", "leader")
      .hasKeyWithValue(predicate)
      .hasContentType("application/json; charset=utf-8")
      .assertAll();

        /*
        status code
        deserialization check
        body value
        contentType
         */
  }

}
