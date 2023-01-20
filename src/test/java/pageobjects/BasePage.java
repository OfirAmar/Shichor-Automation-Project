package pageobjects;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	Actions actions;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, (Duration.ofSeconds(10)));
		actions = new Actions(driver);
	}

	public void fillText(WebElement el, String text) {
		// highlight
		highlightElement(el, "yellow");
		clearInput(el);
		sleep(200);
		el.sendKeys(text);
		
	}
	public void clearInput(WebElement el) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '';", el);
		
	}

	public void click(WebElement el) {
		// highlight
		highlightElement(el, "orange");
		sleep(300);
		el.click();
	}
	 


	public void alertOK() {
		driver.switchTo().alert().accept();
	}
	
	public void moveTo(WebElement el) {
		actions.moveToElement(el).build().perform();
		
	}

	public void sleep(int mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Call this method with your element and a color like (red,green,orange etc...)
	 */
	protected void highlightElement(WebElement element, String color) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:yellow; border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}


}