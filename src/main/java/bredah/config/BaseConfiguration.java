package bredah.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
  "system:properties",
  "classpath:general.properties"
})
public interface BaseConfiguration extends Config {

  @Key("appium.uri")
  String appiumURI();

  @Key("url")
  String url();

  @Key("timeout")
  int timeout();

}
