package selenium_cherkasov.applogic;

import org.openqa.selenium.By;

import selenium_cherkasov.model.User;

public interface UserHelper {

	void loginAs(User user);
	void logout();
	boolean isLoggedIn();
	boolean isLoggedInAs(User user);
	boolean isNotLoggedIn();
	void createUser(User user);
	void clickMyApplicationsLink();
	boolean isElementPresent(By locator);
	

}
