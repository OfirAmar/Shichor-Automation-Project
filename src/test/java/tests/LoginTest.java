package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginTest extends BaseTest{

	@Test
	public void tc_01_loginFailed() {

		HomePage hm = new HomePage(driver);
		hm.closeMsg();
		hm.openLogin();
		LoginPage lg = new LoginPage(driver);
		lg.login("ofiram2511@gmail.com","");
		String expected = "Required";
		String actual = lg.requiredPassMsg();
		AssertJUnit.assertEquals(actual, expected);
		
	}@Test
	public void tc_02_loginFailed2() {
		
		LoginPage lg = new LoginPage(driver);
		lg.login("ofiram2511@gmail.com", "123456");
		String expected = "Unable to log in with provided credentials.";
		String actual = lg.getErrorMsg();
		AssertJUnit.assertEquals(actual, expected);

	}
	@Test
	public void tc_03_login() {
		LoginPage lg = new LoginPage(driver);
		lg.login("ofiram2511@gmail.com", "Offman25");
		
	}
	@Test
	public void tc_04_logout() {
		HomePage hp = new HomePage(driver);
		hp.logOut();
	
	}
	@Test
	public void tc_05_loginAgain() {
		HomePage hp = new HomePage(driver);
		hp.openLogin();
		LoginPage lg = new LoginPage(driver);
		lg.login("ofiram2511@gmail.com", "Offman25");
		
	}
	@Test
	public void tc_06_chooseService() {
		HomePage hm = new HomePage(driver);
		hm.chooseFlightsService();
		
	}

}
