package selenium_cherkasov.applogic1;


import org.openqa.selenium.Keys;

import selenium_cherkasov.applogic.JsHelper;
import selenium_cherkasov.pages.JsTestPage;

public class JsHelper1 extends DriverBasedHelper implements JsHelper {

	public JsHelper1(ApplicationManager1 manager) {
	    super(manager.getWebDriver());
	  }
	
	@Override
	public void getCoordinates() {
    pages.jsTestPage.setTopField(pages.jsTestPage.getTopFindMeField());
	pages.jsTestPage.setLeftField(pages.jsTestPage.getLeftFindMeField());
	pages.jsTestPage.clickProcessButton();
	}


	
	
}
