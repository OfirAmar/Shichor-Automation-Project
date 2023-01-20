package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyTripsPage extends BasePage {

	@FindBy (css="[class='bookmarks-trips-list__empty-state-button'] [dir='ltr']")
	private WebElement createTripBtn;
	@FindBy (css="div:nth-child(1) >.show-md > button")
	private WebElement startPlanningBtn;
	@FindBy (css=".hero-destination__select.css-2b097c-container")
	private WebElement destinationBtn;
	@FindBy (css=".css-1uccc91-singleValue")
	private WebElement destinationField;
	@FindBy (css=".btn-blue.btn")
	private WebElement nextStepBtn;
	@FindBy (css=".create-trip-back")
	private WebElement destinationText;

	public MyTripsPage(WebDriver driver) {  
		super(driver);

	}

	public void createNewTrip(String destination) {
		wait.until(ExpectedConditions.elementToBeClickable(createTripBtn));
		click(createTripBtn);
		wait.until(ExpectedConditions.elementToBeClickable(startPlanningBtn));
		click(startPlanningBtn);
		wait.until(ExpectedConditions.elementToBeClickable(destinationBtn));
		List<WebElement> list = driver.findElements(By.cssSelector("[id='search-bar.to']"));
		for (int i = 0; i < list.size(); i++) {
			list.get(1).sendKeys(destination);
			list.get(1).sendKeys(Keys.ENTER);
			break;
		}


	}
	public String destinationChosen() {
		return destinationText.getText();
		

	}

}
