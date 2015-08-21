package selenium_cherkasov.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsTest extends selenium_cherkasov.pages.TestBase {

	@BeforeMethod
	  public void mayBeLogout() {
	    if (app.getUserHelper().isLoggedIn()) {
	      app.getUserHelper().logout();
	    }
	  }
	
	@Test
	public void getFindMeField() {
		app.getUserHelper().loginAs(ADMIN);
		app.getNavigationHelper().gotoJsTestPage();
		app.getJsHelper().getCoordinates();
	}
}		
	/**}
	String applicationName = Application.getTitle();
	String xpathApp = "//a[contains(@href, '" + applicationName + "')]";
}**/
