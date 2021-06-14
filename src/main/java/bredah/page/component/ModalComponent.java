package bredah.page.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bredah.page.PageObject;

public class ModalComponent extends PageObject {
  
  @FindBy(css = ".bx-wrap .bx-close-link")
  private WebElement linkClose;

  public void closeModal(){
    this.linkClose.click();
  }
}
