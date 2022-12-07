package com.tmb.tests.api.assertwrapper;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

import java.util.function.Predicate;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {

  private SoftAssertions softAssertions;

  private ResponseAssert(Response response) {
    super(response, ResponseAssert.class);
    softAssertions = new SoftAssertions();
  }

  public static ResponseAssert assertThat(Response response) {
    return new ResponseAssert(response);
  }

  public ResponseAssert statusCodeIs(int expectedStatusCode) {
    softAssertions.assertThat(actual.statusCode())
      .isEqualTo(expectedStatusCode);
    return this;
  }

  public ResponseAssert canBeDeserializedTo(Class clazz) {
    softAssertions.assertThatCode(() -> actual.as(clazz))
      .doesNotThrowAnyException();
    return this;
  }

  public ResponseAssert hasKeyWithValue(String key, String value) {
    softAssertions.assertThat(actual.getBody().jsonPath().getString(key))
      .isEqualTo(value);
    return this;
  }

  public ResponseAssert hasKeyWithValue(Predicate<Response> predicate) {
    softAssertions.assertThat(predicate)
      .accepts(actual);
    return this;
  }

  public ResponseAssert hasContentType(String contentType) {
    softAssertions.assertThat(actual.getContentType())
      .isEqualTo(contentType);
    return this;
  }

  public void assertAll() {
    softAssertions.assertAll();
  }
}
