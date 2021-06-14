package bredah.report;

import static bredah.config.ConfigurationManager.baseConfiguration;
import static org.openqa.selenium.OutputType.BYTES;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.TakesScreenshot;

import bredah.driver.DriverManager;
import io.qameta.allure.Attachment;

public class AllureReport {

  private AllureReport(){}

  public static void setAllureEnvironmentInformation() {
    AllureEnvironmentWriter.allureEnvironmentWriter
      (ImmutableMap.<String, String>builder()
        // .put("Test URL", baseConfiguration().url())
        // .put("Target execution", configuration().target())
        // .put("Global timeout", String.valueOf(configuration().timeout()))
        // .put("Browser", configuration().browser())
        // .put("Grid URL", configuration().gridUrl())
        // .put("Grid port", configuration().gridPort())
        .build());
  }

  @Attachment(value = "Failed test screenshot", type = "image/png")
  public static byte[] takeScreenshot() {
    return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
  }

  @Attachment(value = "Browser information", type = "text/plain")
  public static String browserInformation() {
    return DriverManager.getInfo();
  }

}
