package selenium_cherkasov.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EditAccountPage extends AnyPage {

	public EditAccountPage(PageManager pages) {
		super(pages);
	}

	public EditAccountPage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.xpath("//h1[contains(text(),'Edit account')]")));
	    return this;
	  }
	
	@FindBy(name= "fname")
	private WebElement firstNameField;
	
	@FindBy(name= "lname")
	private WebElement lastNameField;
	
	@FindBy(name= "currentPassword")
	private WebElement currentPasswordField;
	
	@FindBy(name= "password")
	private WebElement newPasswordField;
	
	@FindBy(name= "passwordConfirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath= "//input[@value='Update']")
	private WebElement updateButton;
	
	public String getFirstName() {
	return firstNameField.getAttribute("value");
	  }

	public String getLastName() {
	return lastNameField.getAttribute("value");
	}
	
	public EditAccountPage setFirstNameField(String text) {
		firstNameField.sendKeys(text);
		return this;
	}
	
	public EditAccountPage setLastNameField(String text) {
		lastNameField.sendKeys(text);
		return this;
	}
	
	public EditAccountPage setCurrentPasswordField(String text) {
		currentPasswordField.sendKeys(text);
		return this;
	}
	
	public EditAccountPage setNewPasswordField(String text) {
		newPasswordField.sendKeys(text);
		return this;
	}
	
	public EditAccountPage setConfirmPasswordField(String text) {
		confirmPasswordField.sendKeys(text);
		return this;
	}
	public EditAccountPage updateButton() {
		updateButton.click();
		return this;
	}
	
}