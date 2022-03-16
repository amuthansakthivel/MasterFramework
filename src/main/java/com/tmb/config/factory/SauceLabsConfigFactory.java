package com.tmb.config.factory;

import com.tmb.config.SauceLabsConfig;
import org.aeonbits.owner.ConfigCache;

public final class SauceLabsConfigFactory {

    private SauceLabsConfigFactory(){}

    public static SauceLabsConfig getConfig(){
        return ConfigCache.getOrCreate(SauceLabsConfig.class);
    }
}
