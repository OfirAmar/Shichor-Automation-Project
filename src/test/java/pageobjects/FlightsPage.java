package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightsPage extends BasePage{
	@FindBy (css="#cookies_accept")
	private WebElement acceptCookiesBtn;

	public FlightsPage(WebDriver driver) {
		super(driver);
		
	}
	public void acceptCookies() {
		wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesBtn));
		click(acceptCookiesBtn);
	}
	
	public void choosePopularDestination() {
//		List<WebElement> list = driver.findElements(By.cssSelector("PictureCardstyled__Container-sc-1i137c0-0 ehEyCs"));
//		for (int i = 0; i < list.size(); i++) {
//		
//			click(list.get(i));
//			break;
//		}
		
		
	}

}
