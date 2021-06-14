package bredah.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class HeaderPage extends PageObject {
  
  @FindBy(css = "[data-test-name=header-login-button]")
  private WebElement buttonLogIn;

  @FindBy(css = "[data-test-name=header-login-button]")
  private WebElement buttonRegister;

  @FindBy(css = "[data-event=openPanel]")
  private WebElement linkOpenMenu;

  @FindBy(css = "[data-test-name=CloseIcon]")
  private WebElement buttonCloseMenu;

  @Step("access login page")
  public void gotToLogIn(){
    this.buttonLogIn.click();
  }
  
  @Step("access register page")
  public void goToRegister(){
    this.buttonLogIn.click();
  }

  @Step("check if the menu is open")
  public boolean isMenuOpen(){
    return this.buttonCloseMenu.isDisplayed();
  }

  @Step("close menu")
  public void closeMenu() {
    if(this.buttonCloseMenu.isDisplayed()){
      this.buttonCloseMenu.click();
    }
  }

  @Step("open menu")
  public void openMenu() {
    if(!this.buttonCloseMenu.isDisplayed()){
      this.linkOpenMenu.click();
    }
  }

}
