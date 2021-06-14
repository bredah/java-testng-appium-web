package bredah.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class HomePage extends PageObject {
  
  @FindBy(css = "#CybotCookiebotDialogBody #CybotCookiebotDialogBodyButtonAccept")
  private WebElement linkAcceptCookies;

  @Step("accept cookies")
  public void acceptCookies(){
    if(this.linkAcceptCookies.isDisplayed()){
      this.linkAcceptCookies.click();
    }
  }

}
