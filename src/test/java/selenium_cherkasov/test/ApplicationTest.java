package selenium_cherkasov.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium_cherkasov.model.Application;

public class ApplicationTest extends selenium_cherkasov.pages.TestBase {
	
	
	@BeforeMethod
	  public void mayBeLogout() {
	    if (app.getUserHelper().isLoggedIn()) {
	      app.getUserHelper().logout();
	    }
	  }
	
	/**@Test
	public void createNewApplicationWithoutImage() {
		 app.getUserHelper().loginAs(ADMIN);
		 app.getNavigationHelper().gotoNewApplicationsPage();
		 app.getApplicationHelper().create(APPLICATIONWITHOUTIMAGE);
		 //Assert.assertTrue(app.getApplicationHelper().isApplicationExist(APPLICATIONWITHOUTIMAGE));
	 }**/
	
	@Test
	public void createNewApplicationWithImage() {
		 app.getUserHelper().loginAs(ADMIN);
		 app.getNavigationHelper().gotoNewApplicationsPage();
		 app.getApplicationHelper().create(APPLICATIONWITHIMAGE);
		 //Assert.assertTrue(app.getApplicationHelper().isApplicationExist(APPLICATIONWITHOUTIMAGE));
	 }
	
	/**@Test
	public void editApplicationWithoutImage() {
		app.getUserHelper().loginAs(ADMIN);
		app.getNavigationHelper().gotoNewApplicationsPage();
		app.getApplicationHelper().create(APPLICATIONWITHOUTIMAGE);
		//app.getNavigationHelper().gotoEditApplicationsPage();
		//app.getApplicationHelper().Edit(application);
	}**/

	/**@Test
	public void deleteApplication() {
		 app.getUserHelper().loginAs(ADMIN);
		 //app.getApplicationHelper().create(APPLICATIONWITHOUTIMAGE);
		 app.getApplicationHelper().delete(APPLICATIONWITHOUTIMAGE);
		 Assert.assertFalse(app.getApplicationHelper().isApplicationExist(APPLICATIONWITHOUTIMAGE));
	 
	}**/
}
