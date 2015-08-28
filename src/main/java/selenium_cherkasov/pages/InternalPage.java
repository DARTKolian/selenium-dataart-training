package selenium_cherkasov.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import selenium_cherkasov.model.Application;

public class InternalPage extends AnyPage {

	public InternalPage(PageManager pages) {
		super(pages);
	}
	
  public InternalPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.xpath("//a[contains(text(),'Home')]")));
    return this;
  }
  
  
  @FindBy(xpath = "//a[contains(text(),'Ajax test page')]")
  private WebElement ajaxTestPageLink;

  @FindBy(xpath = "//a[contains(text(),'JS test page')]")
  private WebElement jsTestPageLink;

  @FindBy(xpath = "//a[contains(text(),'Home')]")
  private WebElement homeLink;
  
  @FindBy(xpath = "//a[contains(text(),'My applications')]")
  private WebElement myApplicationsLink;
  
  @FindBy(xpath = "//a[contains(text(),'Edit account')]")
  private WebElement editAccountLink;
  
  @FindBy(xpath = "//a[contains(text(),'Logout')]")
  private WebElement logoutLink;
  
  @FindBy(xpath = "//a[contains(text(),'Details')]")
  private WebElement anyApplicationDetailsLink;
  
  @FindBys(@FindBy(xpath = "//div[@class='name']"))
  private List <WebElement> applicationTitles;
  
   
  public AjaxTestPage clickAjaxTestPage() {
  ajaxTestPageLink.click();
  return pages.ajaxTestPage;
  }
  
  public JsTestPage clickJSTestPage() {
  jsTestPageLink.click();
  return pages.jsTestPage;
  }

  public InternalPage clickHomePage() {
  homeLink.click();
  return this;
  }
  
  public MyApplicationsPage clickMyApplicationsPage() {
  myApplicationsLink.click();
  return pages.myApplicationsPage;
  }
  
  public EditAccountPage clickEditAccountPage() {
  editAccountLink.click();
  return pages.editAccountPage;
  }
  
  public LoginPage clickLogoutLink() {
  logoutLink.click();
  return pages.loginPage;
  }
  
  public ApplicationPage clickAnyApplicationDetailsLink() {
  anyApplicationDetailsLink.click();
  return pages.applicationPage;
  }
  
  public InternalPage getListOfApplicationTitles() {
	  
	  return this;
  }
  
  public boolean isElementPresent(By locator) {
	    try {
	    	driver.findElement(locator);
	    	return true;
	    } catch (NoSuchElementException e) {
	    	return false;
	    }  
  }



}
