package selenium_cherkasov.applogic1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import selenium_cherkasov.applogic.UserHelper;
import selenium_cherkasov.model.User;
import selenium_cherkasov.pages.EditAccountPage;

public class UserHelper1 extends DriverBasedHelper implements UserHelper {

  public UserHelper1(ApplicationManager1 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void loginAs(User user) {
    pages.loginPage.ensurePageLoaded()
      .setUsernameField(user.getUsername())
      .setPasswordField(user.getPassword())
      .clickSubmitButton();
  }

  @Override
  public void logout() {
	
    pages.internalPage.ensurePageLoaded()
      .clickLogoutLink();
  }

  @Override
  public boolean isLoggedIn() {
    return pages.internalPage.waitPageLoaded();
  }

  @Override
  public boolean isLoggedInAs(User user) {
    return isLoggedIn()
        && getLoggedUser().getFirstname().equals(user.getFirstname());
  }
  
  
  @Override
  public boolean isNotLoggedIn() {
    return pages.loginPage.waitPageLoaded();
  }
  
  private User getLoggedUser() {
	  EditAccountPage userProfile = pages.internalPage.ensurePageLoaded()
      .clickEditAccountPage()
      .ensurePageLoaded();
    return new User()
      .setFirstname(userProfile.getFirstName())
      .setLastname(userProfile.getLastName());
       }

@Override
public void createUser(User user) {
	pages.loginPage.ensurePageLoaded().clickRegisterAsANewUserLink();
	pages.registerNewUserPage.ensurePageLoaded()
	.setNameField(user.getUsername())
	.setFirstNameField(user.getFirstname())
	.setLastNameField(user.getLastname())
	.setPasswordField(user.getPassword())
	.setPasswordConfirmField(user.getPassword())
	.setRole(user.getRole())
	.clickRegisterButton();
	}

@Override
public void clickMyApplicationsLink() {
  pages.internalPage.ensurePageLoaded()
  .clickMyApplicationsPage();
}



@Override
public boolean isElementPresent(By locator) {
	try {
		driver.findElement(locator);
		return true;
	}
	catch (NoSuchElementException e)
	{
		return false;
	}
	}

}