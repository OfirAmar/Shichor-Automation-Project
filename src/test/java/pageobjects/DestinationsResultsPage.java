package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DestinationsResultsPage extends BasePage{
	@FindBy (css=".destinations-page-item__link.d-block.flex-fill")
	private WebElement citiesBtn;

	public DestinationsResultsPage(WebDriver driver) {


		super(driver);

	}
	public void chooseCity() {
		sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".destinations-page-item__link.d-block.flex-fill")));
		click(citiesBtn);

	}


}
