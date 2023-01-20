package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class ProfilePage extends BasePage {
	@FindBy (css="[class='nav-mobile__profile']")
	private WebElement profileBtn;
	@FindBy (css=".profile-section__edit-btn .btn-blue-outlined.btn")
	private WebElement editProfileBtn;
	@FindBy (css="[name='date_of_birth']")
	private WebElement dateOfBirthField;
	@FindBy (css="[class='btn-blue profile-modal__submit-btn btn']")
	private WebElement saveBtn;
	@FindBy (css="#first_name")
	private WebElement firstNameField;
	@FindBy (css="#last_name")
	private WebElement lastNameField;
	@FindBy (css=".btn-blue-outlined.btn")
	private WebElement editMyPreferences;
	@FindBy (css=".vector-icon.select__chevron")
	private WebElement selectPurpose;
	@FindBy (css="#ssIFrame_google")
	private WebElement preferencesFrame;
	@FindBy (css=".profile-modal__submit-btn.btn")
	private WebElement savePreferencesBtn;
	@FindBy (css="#ssIFrame_google")
	private WebElement personalDetailsFrame;
	@FindBy (css="#old_password")
	private WebElement oldPasswordField;
	@FindBy (css="#new_password1")
	private WebElement newPasswordField;
	@FindBy (css="#new_password2")
	private WebElement newPasswordField2;
	@FindBy (css=".btn-blue.profile-modal__submit-btn.btn")
	private WebElement savePasswordBtn;
	



	public ProfilePage(WebDriver driver) {
		super(driver);

	}

	public void editDateOfBirth(String Birthday) {
		wait.until(ExpectedConditions.elementToBeClickable(editProfileBtn));
		click(editProfileBtn);
		wait.until(ExpectedConditions.elementToBeClickable(dateOfBirthField));
		fillText(dateOfBirthField, Birthday);
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		click(saveBtn);
		sleep(2000);

	}
	public void editFirstName(String first) {
		wait.until(ExpectedConditions.elementToBeClickable(editProfileBtn));
		click(editProfileBtn);
		wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
		fillText(firstNameField, first);
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		click(saveBtn);
		sleep(2000);
	}

	public String getName() {
		String name = firstNameField.getAttribute("value");
		System.out.println(name);
		return name;
	}

	public void editPurposeTrip(String purpose) {
		wait.until(ExpectedConditions.elementToBeClickable(editProfileBtn));
		List<WebElement> list = driver.findElements(By.cssSelector("[class='profile-section__edit-btn']"));
		for (int i = 0; i < list.size(); i++) {
			click(list.get(1));
			break;
		}
		click(selectPurpose);
		sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".m-select__option.css-195wt8y-option")));
		List<WebElement>list1 = driver.findElements(By.cssSelector(".m-select__option.css-195wt8y-option"));
		for (WebElement el : list1) {
			if (el.getText().equalsIgnoreCase(purpose)) {
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".m-select__option.css-195wt8y-option")));
				click(el);
				wait.until(ExpectedConditions.elementToBeClickable(savePreferencesBtn));
				click(savePreferencesBtn);
				sleep(2000);
				break;

			} 
			else {
				WebElement focusedOption = driver.findElement(By.cssSelector(".m-select__option--is-focused.m-select__option--is-selected.css-2srn3s-option"));
				click(focusedOption);
				wait.until(ExpectedConditions.elementToBeClickable(savePreferencesBtn));
				click(savePreferencesBtn);
				sleep(2000);
				break;
			}

		}

	}

	public void editFinancialStandard(String kind) {
		wait.until(ExpectedConditions.elementToBeClickable(editProfileBtn));
		List<WebElement> list3 = driver.findElements(By.cssSelector("[class='profile-section__edit-btn']"));
		for (int i = 0; i < list3.size(); i++) {
			click(list3.get(1));
			sleep(1000);
			break;
		}
		sleep(1000);
		List<WebElement> list2 = driver.findElements(By.cssSelector(".vector-icon.select__chevron"));
		for (int i = 0; i < list2.size(); i++) {
			click(list2.get(1));
			break;
		}
		sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".m-select__option.css-195wt8y-option")));
		List<WebElement> list = driver.findElements(By.cssSelector(".m-select__option.css-195wt8y-option"));
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(kind)) {
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".m-select__option.css-195wt8y-option")));
				click(el);
				wait.until(ExpectedConditions.elementToBeClickable(savePreferencesBtn));
				click(savePreferencesBtn);
				break;	
			}
			else {
				WebElement focusedEl = driver.findElement(By.cssSelector(".m-select__option--is-focused.m-select__option--is-selected.css-2srn3s-option"));
				click(focusedEl);
				wait.until(ExpectedConditions.elementToBeClickable(savePreferencesBtn));
				click(savePreferencesBtn);
				break;	
			}


		}



	}
	
	public void changePassword (String oldPassword, String newPassword) {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".account-settings__section-icon")));
		List<WebElement> list = driver.findElements(By.cssSelector(".account-settings__section-icon"));
		for (int i = 0; i < list.size(); i++) {
			click(list.get(2));
			break;
			
		}
		wait.until(ExpectedConditions.elementToBeClickable(oldPasswordField));
		fillText(oldPasswordField, oldPassword);
		wait.until(ExpectedConditions.elementToBeClickable(newPasswordField));
		fillText(newPasswordField, newPassword);
		wait.until(ExpectedConditions.elementToBeClickable(newPasswordField2));
		fillText(newPasswordField2, newPassword);
		wait.until(ExpectedConditions.elementToBeClickable(savePasswordBtn));
		click(savePasswordBtn);
		
	}




}
