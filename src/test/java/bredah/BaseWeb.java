package bredah;

import static bredah.config.ConfigurationManager.baseConfiguration;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import bredah.driver.DriverManager;
import bredah.driver.TargetFactory;
import bredah.report.AllureReport;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

@Listeners({ TestListener.class })
public abstract class BaseWeb {

  @BeforeSuite
  @Parameters("platform")
  public void beforeSuite(@Optional("android") String platform) {
    AllureReport.setAllureEnvironmentInformation();
    AppiumDriver<MobileElement> driver = new TargetFactory().createInstance(platform);
    DriverManager.setDriver(driver);
    DriverManager.getDriver().get(baseConfiguration().url());
  }

  @AfterSuite
  public void afterSuite() {
    DriverManager.quit();
  }

}
