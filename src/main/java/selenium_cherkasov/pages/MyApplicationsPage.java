package selenium_cherkasov.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyApplicationsPage extends AnyPage {

	public MyApplicationsPage(PageManager pages) {
		super(pages);
	}

	public MyApplicationsPage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.xpath("//a[contains(text(),'Click to add new application')]")));
	    return this;
	  }
	
	@FindBy(xpath= "//a[contains(text(),'Click to add new application')]")
	private WebElement addNewApplicationLink;
	
	@FindBy(xpath = "//div[@class='name']")
	private WebElement applicationTitle;
	
	public NewApplicationPage clickAddNewApplicationLink() {
		addNewApplicationLink.click();
		return pages.newApplicationPage;
		}
	
	public WebElement getApplicationTitle() {
	return pages.myApplicationsPage.applicationTitle;
    }
	
}