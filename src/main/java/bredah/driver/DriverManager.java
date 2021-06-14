package bredah.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverManager {

  private static AppiumDriver<MobileElement> driver;

  private DriverManager() {
  }

  public static AppiumDriver<MobileElement> getDriver() {
    return DriverManager.driver;
  }

  public static void setDriver(AppiumDriver<MobileElement> driver) {
    DriverManager.driver = driver;
  }

  public static void quit() {
    DriverManager.driver.quit();
  }

  public static String getInfo() {
    Capabilities capabilities = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
    String browserName = capabilities.getBrowserName();
    String browserVersion = capabilities.getCapability("capabilityName").toString();
    String platformName = capabilities.getCapability("capabilityName").toString();
    String platformVersion = capabilities.getCapability("capabilityNam").toString();
    return String.format("platform: %s - %s, browser: %s - %s",
      platformName,
      platformVersion,
      browserName,
      browserVersion);
  }

}
