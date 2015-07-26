package selenium_cherkasov.pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import selenium_training.applogic.ApplicationManager;
import selenium_training.applogic0.ApplicationManager0;
import selenium_training.applogic1.ApplicationManager1;
import selenium_training.applogic2.ApplicationManager2;

public class TestBase {

  protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager2();
	}
	@AfterSuite
	public void stop() {
		app.stop();
	}
	

}
