package com.tmb.api;

import com.tmb.api.pojos.UserDetails;
import com.tmb.config.factory.ApiConfigFactory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class ReqresApi {

  private ReqresApi() {
  }

  private static final String LIST_USERS_ENDPOINT = ApiConfigFactory.getConfig().listUserEndpoint();
  private static final String POST_USERS_ENDPOINT = ApiConfigFactory.getConfig().postUserEndpoint();

  public static Response getUsers() {
    return BaseRequestSpecification.getDefaultRequestSpec()
      .queryParam("page", 2)
      .get(LIST_USERS_ENDPOINT);
  }

  public static Response postUsers(UserDetails userDetails) {
    return BaseRequestSpecification.getDefaultRequestSpec()
      .contentType(ContentType.JSON)
      .body(userDetails)
      .post(POST_USERS_ENDPOINT);
  }
}
