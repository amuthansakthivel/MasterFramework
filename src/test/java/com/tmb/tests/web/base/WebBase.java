package com.tmb.tests.web.base;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.tmb.driver.Driver;
import com.tmb.tests.Base;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class WebBase extends Base {

    @BeforeAll
    public static void beforeAll(){
        FixtureFactoryLoader.loadTemplates("com.tmb.fixtures");
    }

    @BeforeEach
    public void setUp(){
        Driver.initDriverForWeb();
    }

    @AfterEach
    public void tearDown(){
        Driver.quitDriver();
    }
}
