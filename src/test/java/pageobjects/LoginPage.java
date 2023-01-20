package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

	@FindBy (css="#email")
	private WebElement emailField;
	@FindBy (css="[name='password']")
	private WebElement passwordField;
	@FindBy (css="[class='btn-blue btn-fluid btn']")
	private WebElement loginBtn;
	@FindBy (css="[class='sign-in-form'] [class='form-error']")
	private WebElement errorMsg;
	@FindBy (css="[class='form-error-message']")
	private WebElement requiredMsg;
	


	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String email, String password) {

//		wait.until(ExpectedConditions.elementToBeClickable(emailField));
		fillText(emailField, email);
		wait.until(ExpectedConditions.elementToBeClickable(passwordField));
		click(passwordField);
		fillText(passwordField, password);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		click(loginBtn);
		wait.until(ExpectedConditions.elementToBeClickable(emailField));
		clearInput(emailField);
		wait.until(ExpectedConditions.elementToBeClickable(passwordField));
		clearInput(passwordField);
	}
	
	public String getErrorMsg() {
		wait.until(ExpectedConditions.elementToBeClickable(errorMsg));
		return errorMsg.getText();
		
	}
	public String requiredPassMsg() {
		return requiredMsg.getText();
		
	}
}