package bredah.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
  "system:properties",
  "classpath:android.properties"
})
public interface AndroidConfiguration extends Config {
  
  @Key("platform.name")
  String platformName();

  @Key("platform.version")
  String platformVersion();

  @Key("device.name")
  String deviceName();

  @Key("automation.name")
  String automationName();

  @Key("app.path")
  String appPath();

  @Key("browser.name")
  String browserName();

  @Key("driver.version")
  String driverVersion();

}
