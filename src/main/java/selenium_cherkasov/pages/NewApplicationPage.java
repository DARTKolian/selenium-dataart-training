package selenium_cherkasov.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class NewApplicationPage extends AnyPage {

	public NewApplicationPage(PageManager pages) {
		super(pages);
	}

	public NewApplicationPage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.xpath("//h1[contains(text(),'New application')]")));
	    return this;
	  }
	
	@FindBy(name= "title")
	private WebElement titleField;
	
	@FindBy(name= "description")
	private WebElement descriptionField;
	
	
	private Select categoryDropdown() {
	return new Select(driver.findElement(By.xpath("//select[@name='category']")));
	}
	
	
	//@FindBy(name= "category")
	//private WebElement category;
	
	//Select categoryDropdown = new Select(category);
	
	//private Select categoryDropdown = new Select(driver.findElement(By.xpath("//select[@name='category']")));
	
	@FindBy(name= "image")
	private WebElement imageLoader;
	
	@FindBy(name= "icon")
	private WebElement iconLoader;
			
	@FindBy(xpath= "//input[@value='Create']")
	private WebElement createButton;
	
	public NewApplicationPage setTitleField(String text) {
		titleField.sendKeys(text);
		return this;
	}
	
	public NewApplicationPage setDescriptionField(String text) {
		descriptionField.sendKeys(text);
		return this;
	}
	
		
	public NewApplicationPage setImage(String text) {
		imageLoader.sendKeys(text);
		return this;
	}
	
	public NewApplicationPage setIcon(String text) {
		iconLoader.sendKeys(text);
		return this;
	}
	
	public NewApplicationPage setCategory(String valueToSelect) {
		System.out.println("Value = " + categoryDropdown().getFirstSelectedOption().getText());
		categoryDropdown().selectByValue(valueToSelect);
		//categoryDropdown.selectByIndex(1);
		return this;
	}
	
	public NewApplicationPage clickCreateButton() {
		createButton.click();
		return this;
	}

	
}