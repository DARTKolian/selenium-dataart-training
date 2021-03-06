package selenium_cherkasov.applogic1;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import selenium_cherkasov.applogic.ApplicationHelper;
import selenium_cherkasov.model.Application;
import selenium_cherkasov.model.User;
import selenium_cherkasov.pages.ApplicationPage;
import selenium_cherkasov.pages.EditAccountPage;
import selenium_cherkasov.pages.InternalPage;

public class ApplicationHelper1 extends DriverBasedHelper implements ApplicationHelper {

  public ApplicationHelper1(ApplicationManager1 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Application application) {
    pages.newApplicationPage.ensurePageLoaded()
    .setTitleField(application.getTitle())
    .setDescriptionField(application.getDescription())
    //.setCategory(application.getCategory())
    .clickCreateButton();
   }
  
  @Override
  public void downloadAppJson() {
	  pages.internalPage.ensurePageLoaded().clickAnyApplicationDetailsLink();
	  pages.applicationPage.clickDownloadButton();
	  
	  // Wait while page with json loaded
	  
	  String jsonStr = driver.findElement(By.tagName("pre")).getText();
	  
	  JSONObject json = new JSONObject(jsonStr);
	  JSONObject category = json.getJSONObject("category");
	  JSONObject author = json.getJSONObject("author");
	  JSONObject author_roleModel = author.getJSONObject("roleModel");
	  
	  //boolean description = json.getString("description") != "";
	  Assert.assertNotNull(json.getString("description"));
	  Assert.assertNotNull(category.get("id"));
	  Assert.assertNotNull(category.get("title"));
	  //boolean numberOfDownloads = json.getInt("numberOfDownloads") > 0;
	  Assert.assertNotNull(json.getInt("numberOfDownloads"));
	  Assert.assertNotNull(author.get("name"));
	  Assert.assertNotNull(author.get("password"));
	  Assert.assertNotNull(author.get("lname"));
	  Assert.assertNotNull(author.get("fname"));
	  Assert.assertNotNull(author_roleModel.get("name"));
	  Assert.assertNotNull(author_roleModel.get("id"));
	  
	  Assert.assertNotNull(author_roleModel.get("title"));
	  Assert.assertTrue(author_roleModel.getBoolean("developer"));
	
	  Assert.assertTrue(json.isNull("imageData"));
	  Assert.assertTrue(json.isNull("iconData"));
	  Assert.assertNotNull(json.get("title"));
	  Assert.assertNotNull(json.get("uploadedTimeStamp"));
   }
  
  
  @Override
  public void createWithImage(Application application) {
    pages.newApplicationPage.ensurePageLoaded()
    .setTitleField(application.getTitle())
    .setDescriptionField(application.getDescription())
    .setImage(application.getImage())
    .setIcon(application.getIcon())
    //.setCategory(application.getCategory())
    .clickCreateButton();
     }
  
  @Override
  public void Edit(Application application) {
	pages.applicationPage.ensurePageLoaded().clickEditButton();
    pages.editApplicationPage.ensurePageLoaded()
    .clearDescriptionField()
    .setDescriptionField("Edit words")
    .clickUpdateButton(); 
  }

  @Override
  public void delete() {
    pages.applicationPage.ensurePageLoaded().clickDeleteButton();
    }
 

  @Override
  public boolean myApplicationsPageIsLoaded() {
	    return pages.myApplicationsPage.waitPageLoaded();
	  }
  
  @Override
  public boolean isApplicationExist(Application application) {
	  pages.myApplicationsPage.ensurePageLoaded();
	  List<WebElement> titles = driver.findElements(By.className("name"));
	  
	  for(WebElement title : titles) {
		  System.out.println(title.getText());
		  if (title.getText().equals(application.getTitle()))
		  {
			 			  
			  return true;
		  }
	  }
	  return false;
   }

  @Override
  public  void gotoApplicationDetails(Application application) {
	  pages.myApplicationsPage.ensurePageLoaded();
	  List<WebElement> titles = driver.findElements(By.className("name"));
	  
	  for(WebElement title : titles) {
		  System.out.println(title.getText());
		  if (title.getText().equals(application.getTitle()))
		  {
			  //x.GoToUrl("app?title=" + title.getText());
			  WebElement parent = title.findElement(By.xpath(".."));
			  WebElement link = parent.findElement(By.tagName("a"));
			  
			  link.click();
			  
			  return;
		  }
	  }
	  return ;
  }
  
  
  @Override
  public boolean downloadApplicationManyTimes(Application application) {
	  //pages.myApplicationsPage.ensurePageLoaded().clickDetailsLinkText();
	 for (int i = 1; i <= 10; i++) {		
		 pages.applicationPage.ensurePageLoaded().clickDownloadButton();
		 driver.navigate().back();
		  }
	 driver.navigate().refresh();
	 List<WebElement> titles = driver.findElements(By.className("popular-app"));
	  
	 for(WebElement title : titles) {
		  System.out.println(title.getText());
		  if (title.getText().equals(application.getTitle()))
		  {
			    
			  return true;
           }
	  }
	  return false;
   }
 
}


