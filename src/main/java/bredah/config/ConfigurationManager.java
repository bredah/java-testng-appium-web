package bredah.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

  private ConfigurationManager() {
  }

  public static BaseConfiguration baseConfiguration() {
    return ConfigCache.getOrCreate(BaseConfiguration.class);
  }

  public static AndroidConfiguration androidConfiguration() {
    return ConfigCache.getOrCreate(AndroidConfiguration.class);
  }

  public static IosConfiguration iosConfiguration() {
    return ConfigCache.getOrCreate(IosConfiguration.class);
  }
}
