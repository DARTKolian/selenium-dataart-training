package selenium_cherkasov.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import selenium_cherkasov.model.User;

public class LoginTest extends selenium_cherkasov.pages.TestBase {

	  @BeforeMethod
	  public void mayBeLogout() {
	    if (app.getUserHelper().isLoggedIn()) {
	         app.getUserHelper().logout();
	    }
	  }
	  
	  @Test
	  public void testLoginOK() throws Exception {
	    User user = new User().setFirstname("Ivan").setLastname("Petrov");
	    app.getUserHelper().loginAs(ADMIN);
	    Assert.assertTrue(app.getUserHelper().isLoggedInAs(user));
	  }
	  /**JSON response = WebDriver.Pagesource;
	  Assert.True(json.Parse(response).description.Contains("XEP"));
	  Assert.True(json.Parse(response).title.Contains("XEP"));**/
	  
	  @Test
	  public void testLoginFailed() throws Exception {
	  User user = new User().setUsername("admin").setPassword("wrong");
	  app.getUserHelper().loginAs(user);
	  Assert.assertFalse(app.getUserHelper().isLoggedIn());
	  //Assert.assertTrue(app.getUserHelper().isNotLoggedIn());
	  }
}