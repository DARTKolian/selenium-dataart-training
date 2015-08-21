package selenium_cherkasov.applogic;

public interface ApplicationManager {

	UserHelper getUserHelper();
	ApplicationHelper getApplicationHelper();
    NavigationHelper getNavigationHelper();
    AjaxHelper getAjaxHelper();
    JsHelper getJsHelper();

  void stop();


}
