package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.Closeable;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ProfilePage;

public class EditProfileTest extends BaseTest{

	@Test
	public void tc_10_editBirthDay () {
		HomePage hm = new HomePage(driver);
		hm.closeMsg();
		hm.openLogin();

		LoginPage lg = new LoginPage(driver);
		lg.login("ofiram2511@gmail.com", "Offman25");
		hm.openProfile();

		ProfilePage pp = new ProfilePage(driver);
		pp.editDateOfBirth("25111996");
		

	}
	
	@Test
	public void tc_11_editName() {
		ProfilePage pp = new ProfilePage(driver);
		pp.editFirstName("Ofir");
//		String actual = pp.getName();
//		String expected = "Ofir";
//		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void tc_12_PurpuseTrip() {
		ProfilePage pp = new ProfilePage(driver);
		pp.editPurposeTrip("family trip");
	}
	
	@Test
	public void tc_13_chooseFinancialStandard() {
		ProfilePage pp = new ProfilePage(driver);
		pp.editFinancialStandard("comfort");
		
	}
	
	@Test
	public void tc_14_changePassword() {
		ProfilePage pp = new ProfilePage(driver);
		pp.changePassword("Offman25", "Offman2511#");
		
	}

}
