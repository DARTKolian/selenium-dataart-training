package selenium_cherkasov.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AjaxTestPage extends AnyPage {

	public AjaxTestPage(PageManager pages) {
		super(pages);
		}
	
	
	public AjaxTestPage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.id("calc")));
	    return this;
	  }
	
	@FindBy(id= "x")
	private WebElement xField;
	
	@FindBy(id= "y")
	private WebElement yField;
	
	@FindBy(id= "calc")
	private WebElement sumButton;
	
	@FindBy(xpath= "//a[contains(text(),'go back')]")
	private WebElement goBackButton;
	
	@FindBy(id= "r")
	private WebElement resultField;
	
	
	
	public AjaxTestPage setXField(String text) {
	xField.sendKeys(text);
	return this;
	}
	
	public AjaxTestPage setYField(String text) {
	yField.sendKeys(text);
	return this;
	}
	
	public AjaxTestPage clickSumButton() {
	sumButton.click();
	wait.until(presenceOfElementLocated(By.id("result")));
	return this;
	}
	
	public AjaxTestPage resultField() {
	resultField.getText();
	return this;
	}
	
	
	/**public AjaxTestPage inCorrectResult() {
		String message = result.getText();
		Assert.assertEquals(message, "Result is: Incorrect data");
	}**/
	
	public InternalPage clickGoBackButton() {
	goBackButton.click();
	return pages.internalPage;
	}
}
