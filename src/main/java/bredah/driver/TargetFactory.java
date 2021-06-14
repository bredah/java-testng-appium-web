package bredah.driver;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bredah.exceptions.TargetNotValidException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TargetFactory {

  private static final Logger logger = LogManager.getLogger(TargetFactory.class);

  public AppiumDriver<MobileElement> createInstance(String platform) {
    try {
      return DriverFactory.valueOf(platform.toUpperCase()).createDriver();
    } catch (NullPointerException | MalformedURLException e) {
      logger.error(e.getMessage(), e.getCause());
    }
    throw new TargetNotValidException(platform);
  }

}
