package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pageobjects.DestinationsPage;
import pageobjects.DestinationsResultsPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class DestinationsTest extends BaseTest{
	
	@Test
	public void tc_07_goToDestinations() {
		HomePage hm = new HomePage(driver);
		hm.closeMsg();
		hm.openLogin();
		LoginPage lp = new LoginPage(driver);
		lp.login("ofiram2511@gmail.com", "Offman25");
		hm.openDestinations();
		
	}
	
	@Test
	public void tc_08_searchDestination() {
		DestinationsPage dp = new DestinationsPage(driver);
		dp.searchDestination("miami");
		DestinationsResultsPage drp = new DestinationsResultsPage(driver);
		drp.chooseCity();
	}
	

}
