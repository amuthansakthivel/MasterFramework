package com.tmb.config.factory;

import com.tmb.config.BrowserStackConfig;
import org.aeonbits.owner.ConfigCache;

public final class BrowserStackConfigFactory {

  private BrowserStackConfigFactory() {
  }

  public static BrowserStackConfig getConfig() {
    return ConfigCache.getOrCreate(BrowserStackConfig.class);
  }
}
