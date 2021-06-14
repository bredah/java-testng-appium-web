package bredah.driver;

import static bredah.config.ConfigurationManager.androidConfiguration;
import static bredah.config.ConfigurationManager.baseConfiguration;
import static bredah.config.ConfigurationManager.iosConfiguration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.github.bonigarcia.wdm.WebDriverManager;

public enum DriverFactory {
  ANDROID {
    @Override
    public AppiumDriver<MobileElement> createDriver() throws NullPointerException, MalformedURLException{
      return new AndroidDriver<>(new URL(baseConfiguration().appiumURI()), getCapabilities());
    }
    
    @Override
    public DesiredCapabilities getCapabilities(){
      WebDriverManager
          .chromedriver()
          .driverVersion(androidConfiguration().driverVersion())
          .setup();
      var capabilities = new DesiredCapabilities();
      capabilities.setCapability(CapabilityType.PLATFORM_NAME, androidConfiguration().platformName());
      capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, androidConfiguration().platformVersion());
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, androidConfiguration().deviceName());
      capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, androidConfiguration().automationName());
      capabilities.setCapability(CapabilityType.BROWSER_NAME, androidConfiguration().browserName());
      capabilities.setCapability(CHROME_DRIVER_PATH,
        WebDriverManager
          .chromedriver()
          .driverVersion(androidConfiguration().driverVersion())
          .getDownloadedDriverPath());
      return capabilities;
    }
  },
  IOS {
    @Override
    public AppiumDriver<MobileElement> createDriver() throws NullPointerException, MalformedURLException {
      return new IOSDriver<>(new URL(baseConfiguration().appiumURI()), getCapabilities());
    }

    @Override
    public DesiredCapabilities getCapabilities() {
      var capabilities = new DesiredCapabilities();
      capabilities.setCapability(CapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
      capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, iosConfiguration().platformVersion());
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, iosConfiguration().deviceName());
      capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, iosConfiguration().automationName());
      capabilities.setCapability(CapabilityType.BROWSER_NAME, iosConfiguration().browserName());
      return capabilities;
    }
  };
    
  public abstract AppiumDriver<MobileElement> createDriver() throws NullPointerException, MalformedURLException;
  
  public abstract DesiredCapabilities getCapabilities();

  private static final String CHROME_DRIVER_PATH = "chromedriverExecutable";
}
