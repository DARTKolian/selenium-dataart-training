package selenium_cherkasov.applogic;

import java.util.List;

import selenium_cherkasov.model.Application;

public interface ApplicationHelper {

	void create(Application application);
	void delete();
	//List<Application> search(String Title);
	boolean isApplicationExist(Application application);
	boolean myApplicationsPageIsLoaded();
	//String getApplicationTitle();
	void Edit(Application application);
	void createWithImage(Application application);
	void downloadAppJson();
	void gotoApplicationDetails(Application application);
	boolean downloadApplicationManyTimes(Application application);
	
	
	

}
