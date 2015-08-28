package selenium_cherkasov.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AjaxTest extends selenium_cherkasov.pages.TestBase {
	
	@BeforeMethod
	  public void mayBeLogout() {
	    if (app.getUserHelper().isLoggedIn()) {
	      app.getUserHelper().logout();
	    }
	  }
	
	@Test
	public void ajaxSumNOTOK() {
		app.getUserHelper().loginAs(ADMIN);
		app.getNavigationHelper().gotoAjaxTestPage();
		app.getAjaxHelper().SumNOTOK();
		app.getAjaxHelper().ensureIncorrectResult();
		app.getNavigationHelper().openPreviousPage();		
	}

	@Test
	public void ajaxSumOK() {
		app.getUserHelper().loginAs(ADMIN);
		app.getNavigationHelper().gotoAjaxTestPage();
		app.getAjaxHelper().SumOK();
		app.getAjaxHelper().ensureCorrectResult();
		app.getNavigationHelper().openPreviousPage();
	}
}
