package com.tmb.tests.mobile;

import com.tmb.pages.mobile.IosHomeScreen;
import com.tmb.tests.mobile.base.IosSetup;
import org.junit.jupiter.api.Test;

class IosTest extends IosSetup {

    /*
    Please refer mobile test
     */

  @Test
  void testLoginIos() {
    IosHomeScreen.getInstance()
      .addANewTask();

    //add assertion
  }

}
