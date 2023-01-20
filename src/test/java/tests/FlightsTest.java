package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.Set;

import org.testng.annotations.Test;

import pageobjects.FlightsPage;
import pageobjects.HomePage;

public class FlightsTest extends BaseTest{
	
	@Test
	public void tc_09_goToFlightsService () {
		HomePage hp = new HomePage(driver);
		hp.closeMsg();
		hp.chooseFlightsService();
		String main = driver.getWindowHandle();
		FlightsPage fp = new FlightsPage(driver);
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
			
		}
		fp.acceptCookies();
	}

}
