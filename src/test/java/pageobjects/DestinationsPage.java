package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DestinationsPage extends BasePage{
	
	@FindBy (css=".destinations-header__input")
	private WebElement searchField;
	@FindBy (css="[class='destinations-header__form'] [class='destinations-header__btn btn']")
	private WebElement searchBtn;
	
	public DestinationsPage(WebDriver driver) {
		super(driver);
		
	}
	public void searchDestination(String country) {
		fillText(searchField, country);
		sleep(1000);
		click(searchBtn);
	    sleep(1000);

		
		
	}

}
