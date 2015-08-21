package selenium_cherkasov.test;

import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium_cherkasov.model.User;

public class RegistrationTest extends selenium_cherkasov.pages.TestBase {
	
	@BeforeMethod
	  public void mayBeLogout() {
	    if (app.getUserHelper().isLoggedIn()) {
	      app.getUserHelper().logout();
	    }
	  }

	@Test
	public void addnewUserOK() {
		
		app.getUserHelper().createUser(USER);
		Assert.assertTrue(app.getUserHelper().isLoggedInAs(USER));
	}


@Test
public void addnewUserLogoutLoginOK() {
		
	app.getUserHelper().createUser(USER);
	app.getUserHelper().logout();
	app.getUserHelper().loginAs(USER);
	Assert.assertTrue(app.getUserHelper().isLoggedInAs(USER));
    }

/**@Test
public void addnewUserDeveloperUploadOK() {
	
	app.getUserHelper().createUser(DEVELOPER);
	app.getNavigationHelper().gotoNewApplicationsPage();
	Assert.assertTrue(app.getNavigationHelper().NewApplicationsPageIsOpen());
	}**/
	
@Test
public void addnewUserUploadNOTOK() {
	
	app.getUserHelper().createUser(USER);
	app.getNavigationHelper().gotoInternalPage();
	Assert.assertFalse(app.getUserHelper().isElementPresent(By.xpath("//a[contains(text(),'My applications')]")));
	}
}