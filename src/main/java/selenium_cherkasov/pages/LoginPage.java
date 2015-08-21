package selenium_cherkasov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class LoginPage extends AnyPage {

	public LoginPage(PageManager pages) {
		super(pages);
	}
	
  public LoginPage ensurePageLoaded() {
  super.ensurePageLoaded();
  wait.until(presenceOfElementLocated(By.xpath("//a[contains(text(),'Register as a new user')]")));
  return this;
  }

  @FindBy(name = "j_username")
  private WebElement usernameField;

  @FindBy(name = "j_password")
  private WebElement passwordField;

  @FindBy(xpath = "//input[@value='Login']")
  private WebElement submitButton;
  
  @FindBy(xpath = "//a[contains(text(),'Register as a new user')]")
  private WebElement registerAsANewUserLink;
  
  public LoginPage setUsernameField(String text) {
    usernameField.sendKeys(text);
    return this;
  }

  public LoginPage setPasswordField(String text) {
    passwordField.sendKeys(text);
    return this;
  }

  public void clickSubmitButton() {
    submitButton.click();
  }
  
  public RegisterNewUserPage clickRegisterAsANewUserLink() {
	 registerAsANewUserLink.click();
	 return pages.registerNewUserPage;
  }

  }
