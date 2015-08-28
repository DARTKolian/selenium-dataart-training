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
	
	@Test
	public void downloadJSON() {
		app.getUserHelper().loginAs(ADMIN);
		app.getNavigationHelper().gotoInternalPage();
		app.getApplicationHelper().downloadAppJson();
	}
	
	
	@Test
	public void createNewApplicationWithoutImage() {
		 app.getUserHelper().loginAs(ADMIN);
		 app.getNavigationHelper().gotoNewApplicationsPage();
		 Application application = new Application()
		 .setTitle("trololo")
		 .setDescription("popopo");
		 app.getApplicationHelper().create(application);
		 Assert.assertTrue(app.getApplicationHelper().isApplicationExist(application));
	 }
	
	/**@Test
	public void editApplicationWithoutImage() {
		app.getUserHelper().loginAs(ADMIN);
		app.getNavigationHelper().gotoNewApplicationsPage();
		app.getApplicationHelper().create(APPLICATIONWITHOUTIMAGE);
		app.getApplicationHelper().gotoApplicationDetails(APPLICATIONWITHOUTIMAGE);
		app.getApplicationHelper().Edit(APPLICATIONWITHOUTIMAGE);	
	}**/
		
	@Test
	public void createNewApplicationWithImage() {
		 app.getUserHelper().loginAs(ADMIN);
		 app.getNavigationHelper().gotoNewApplicationsPage();
		 app.getApplicationHelper().createWithImage(APPLICATIONWITHIMAGE);
		 Assert.assertTrue(app.getApplicationHelper().isApplicationExist(APPLICATIONWITHIMAGE));
	}
	
		
	@Test
	public void downloadApplicationUntilPopular() {
		app.getUserHelper().loginAs(ADMIN);
		app.getNavigationHelper().gotoNewApplicationsPage();
		app.getApplicationHelper().create(APPLICATIONWITHOUTIMAGE);
		app.getApplicationHelper().gotoApplicationDetails(APPLICATIONWITHOUTIMAGE);
		app.getApplicationHelper().downloadApplicationManyTimes(APPLICATIONWITHOUTIMAGE);
	}

	@Test
	public void deleteApplication() {
		 app.getUserHelper().loginAs(ADMIN);
		 app.getNavigationHelper().gotoNewApplicationsPage();
		 app.getApplicationHelper().create(APPLICATIONWITHOUTIMAGE);
		 app.getApplicationHelper().gotoApplicationDetails(APPLICATIONWITHOUTIMAGE);
		 app.getApplicationHelper().delete();
		 app.getNavigationHelper().gotoMyApplicationsPage();
		 Assert.assertFalse(app.getApplicationHelper().isApplicationExist(APPLICATIONWITHOUTIMAGE));
	}
}
