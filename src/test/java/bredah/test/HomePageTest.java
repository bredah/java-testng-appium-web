package bredah.test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

import bredah.BaseWeb;
import bredah.page.HeaderPage;
import bredah.page.HomePage;

public class HomePageTest extends BaseWeb {

  @Test
  public void mainMenu_validateState() {
    // home page
    var homePage = new HomePage();
    homePage.acceptCookies();
    // header page
    var headerPage = new HeaderPage();
    var isMenuOpen = headerPage.isMenuOpen();
    assertFalse(isMenuOpen, "the menu was expected to be closed");
    headerPage.openMenu();
    assertTrue(isMenuOpen, "the menu was expected to be opened");
  }
}
