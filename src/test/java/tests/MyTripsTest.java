package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyTripsPage;

public class MyTripsTest extends BaseTest{
	@Test
	public void tc_15_openMyTrips() {
		HomePage hm = new HomePage(driver);
		hm.closeMsg();
		hm.openLogin();

		LoginPage lg = new LoginPage(driver);
		lg.login("ofiram2511@gmail.com", "Offman25");
		hm.openMyTrips();
	}
	
	@Test
	public void tc_16_createNewTrip() {
		MyTripsPage mtp = new MyTripsPage(driver);
		mtp.createNewTrip("miami");
		String actual = mtp.destinationChosen();
		String expected = "Miami,USA";
		AssertJUnit.assertEquals(actual, expected);
		//Bug founded!
//		after entering "Miami" in destination field + Enter, it's start to
//		planing trip to Paris!!
		
		
	}
	
	

}
