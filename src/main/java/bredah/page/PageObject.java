package bredah.page;

import static bredah.config.ConfigurationManager.baseConfiguration;
import static org.openqa.selenium.support.PageFactory.initElements;

import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import bredah.driver.DriverManager;

public class PageObject {

  protected PageObject() {
    initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), baseConfiguration().timeout()), this);
  }

}
