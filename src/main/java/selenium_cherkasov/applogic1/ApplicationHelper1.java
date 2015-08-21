package selenium_cherkasov.applogic1;

import java.util.List;

import org.openqa.selenium.By;

import selenium_cherkasov.applogic.ApplicationHelper;
import selenium_cherkasov.model.Application;
import selenium_cherkasov.model.User;
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
    pages.editApplicationPage.ensurePageLoaded()
    .clearDescriptionField()
    .setDescriptionField("Edit words")
    .clickUpdateButton();
    
  }

  @Override
  public void delete(Application application) {
    pages.internalPage.ensurePageLoaded()
    .clickAnyApplicationDetailsLink()
    .clickDeleteButton();
  }
  
 	      

  @Override
  public List<Application> search(String title) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean myApplicationsPageIsLoaded() {
	    return pages.myApplicationsPage.waitPageLoaded();
	  }
  
  @Override
  public String getApplicationTitle() {
	 return driver.findElement(By.xpath("//div[@class='name']")).getText();
	
  }
  
  @Override
  public boolean isApplicationExist(Application application) {
    return myApplicationsPageIsLoaded()
        && getApplicationTitle().equals(application.getTitle());
  }


}