package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.sdk.common.Clock;

public class HomePage extends BasePage{	
	@FindBy (css="[class='vector-icon hanukkah-popup__exit-icon']")
	private WebElement alertBtn;
	@FindBy (css="[class='btn-dark-blue btn']")
	private WebElement signInBtn;
	@FindBy (css="[href='/en/profile']")
	private WebElement profileBtn;
	@FindBy (css=".nav-right__user")
	private WebElement hoverProfile;
	@FindBy (css=".home-content__destinations .btn.btn-link ")
	private WebElement destinationsBtn;
	@FindBy (css=".header-nav__item")
	private WebElement myTripsBtn;
	@FindBy (css="[class='vector-icon header-dropdown__arrow']")
	private WebElement dropArrowBtn;
	@FindBy (xpath="//*[@id=\"__next\"]/header/div/div/div[1]/nav/div/div[1]/div[2]/div/div/a[2]/span")
	private WebElement flightsService;
	@FindBy (css=".nav-right-menu__item")
	private WebElement profileMenuBtn;
	@FindBy (css=".btn-blue.btn-small.btn")
	private WebElement confirmLogoutBtn;

	public HomePage(WebDriver driver) {
		super(driver);

	}
	public void closeMsg() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='vector-icon hanukkah-popup__exit-icon']")));
		click(alertBtn);
	}
	public void openLogin() {
		click(signInBtn);
	}
	public void openProfile() {
		moveTo(hoverProfile);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='/en/profile']")));
		click(profileBtn);
		sleep(1000);
		//wait.until(ExpectedConditions.urlContains(""));

	}
	public void logOut() {
		wait.until(ExpectedConditions.elementToBeClickable(hoverProfile));
		moveTo(hoverProfile);
		wait.until(ExpectedConditions.elementToBeClickable(profileMenuBtn));
		List<WebElement> list = driver.findElements(By.cssSelector(".nav-right-menu__item"));
		for (int i = 0; i < list.size(); i++) {
			click(list.get(1));
			wait.until(ExpectedConditions.elementToBeClickable(confirmLogoutBtn));
			click(confirmLogoutBtn);
			break;
		}



	}



	public void openDestinations() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".home-content__destinations .btn.btn-link")));
		click(destinationsBtn);
	}

	public void openMyTrips() {
		//click(el);
		List<WebElement> list = driver.findElements(By.cssSelector(".header-nav__item"));
		for (int i = 0; i < list.size(); i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header-nav__item")));
			click(list.get(1));
			break;

		}	

	}
	public void chooseFlightsService() {
		//		Select s = new Select(dropArrowBtn);
		//		s.selectByVisibleText(text);
		moveTo(dropArrowBtn);
		wait.until(ExpectedConditions.elementToBeClickable(flightsService));
		click(flightsService);

	}

	public void moveToCotactUs () {
		List<WebElement> list = driver.findElements(By.cssSelector(".footer-list__link"));
		//		System.out.println(list.size());
		for (WebElement el : list) {
			if (el.getText().toLowerCase().contains("contact us")) {
				wait.until(ExpectedConditions.elementToBeClickable(el));
				click(el);
				break;
			}



		}

	}


}
