package selenium_cherkasov.pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import selenium_cherkasov.applogic.ApplicationManager;
import selenium_cherkasov.applogic1.ApplicationManager1;
import selenium_cherkasov.model.Application;
import selenium_cherkasov.model.User;


public class TestBase {
	
	public static User ADMIN = new User().setUsername("admin").setPassword("admin");
	public static User USER = new User().setUsername("user" + System.currentTimeMillis()).setFirstname("Sidor").setLastname("Sidorivich").setPassword("password").setRole("USER");
	public static User DEVELOPER = new User().setUsername("user" + System.currentTimeMillis()).setFirstname("Petr").setLastname("Petrovich").setPassword("password").setRole("DEVELOPER");
	//public static Application APPLICATIONWITHOUTIMAGE = new Application().setTitle("Application" + System.currentTimeMillis()).setDescription("This is no image test").setCategory("Fun");
	public static Application APPLICATIONWITHOUTIMAGE = new Application().setTitle("Application" + System.currentTimeMillis()).setDescription("This is no image test");
	public static Application APPLICATIONWITHIMAGE = new Application().setTitle("Application" + System.currentTimeMillis()).setDescription("This is test with image").setImage("C:\\Users\\ncherkasov\\Desktop\\bigheight401.jpg").setIcon("C:\\Users\\ncherkasov\\Desktop\\bigheight401.jpg");
  
	protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager1();
	}
	@AfterSuite
	public void stop() {
		app.stop();
	}
	

}
