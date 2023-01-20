package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends BasePage{
	@FindBy (css="#from_email")
	private WebElement emailField;
	@FindBy (css="#text")
	private WebElement messageField;
	@FindBy(css="[title='reCAPTCHA']")
	private WebElement frameAtb;
	@FindBy (css="#recaptcha-anchor")
	private WebElement robotBtn;
	@FindBy (css=".btn-blue.btn")
	private WebElement submitBtn;
	

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	public void contactUsMsg(String email, String text) {
		fillText(emailField, email);
		fillText(messageField, text);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameAtb));
		wait.until(ExpectedConditions.elementToBeClickable(robotBtn));
		click(robotBtn);
//		click(submitBtn);
	}

}
