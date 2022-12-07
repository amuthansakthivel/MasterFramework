package com.tmb.config.factory;

import com.tmb.config.ApiConfig;
import org.aeonbits.owner.ConfigCache;

public final class ApiConfigFactory {

  private ApiConfigFactory() {
  }

  public static ApiConfig getConfig() {
    return ConfigCache.getOrCreate(ApiConfig.class);
  }
}
