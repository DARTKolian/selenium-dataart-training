package selenium_cherkasov.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class ApplicationPage extends AnyPage {

	public ApplicationPage(PageManager pages) {
		super(pages);
	}

	public ApplicationPage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.xpath("//div[contains(text(),'Author')]")));
	    return this;
	  }
	
	@FindBy(xpath= "//a[contains(text(),'Download')]")
	private WebElement downloadButton;
	
	@FindBy(xpath= "//a[contains(text(),'Delete')]")
	private WebElement deleteButton;
	
	@FindBy(xpath= "(//a[contains(text(),'Edit')])[2]")
	private WebElement editButton;
	
	@FindBy(name= "save")
	private WebElement saveField;
	
		
	public ApplicationPage clickDeleteButton() {
		deleteButton.click();		
		wait.until(alertIsPresent());
		Assert.assertEquals("Do you want to delete this application?", driver.switchTo().alert().getText());
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
		}
	
	public EditAccountPage clickEditButton() {
		editButton.click();
		return pages.editAccountPage;
		}
	
}