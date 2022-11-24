package com.tmb.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/api-config.properties",
        "file:${user.dir}/src/test/resources/api-staging-config.properties",
        "file:${user.dir}/src/test/resources/api-dev-config.properties"
})
public interface ApiConfig extends Config {

    @Key("api.baseurl")
    String apiBaseUrl();

    @Key("list.users")
    String listUserEndpoint();

    @Key("create.users")
    String postUserEndpoint();
}
