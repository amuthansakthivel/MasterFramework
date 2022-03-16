package com.tmb.config;

import com.tmb.config.converters.StringToURLConverter;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:${user.dir}/src/test/resources/sauce-labs.properties"
})
public interface SauceLabsConfig extends Config {

    @Key("username")
    String userName();

    String key();

    @DefaultValue("saucelabsendpoint")
    @ConverterClass(StringToURLConverter.class)
    URL sauceLabsURL();

}
