package selenium_cherkasov.applogic1;

import org.openqa.selenium.WebDriver;

import selenium_cherkasov.applogic.AjaxHelper;
import selenium_cherkasov.applogic.ApplicationManager;
import selenium_cherkasov.applogic.ApplicationHelper;
import selenium_cherkasov.applogic.JsHelper;
import selenium_cherkasov.applogic.NavigationHelper;
import selenium_cherkasov.applogic.UserHelper;
import selenium_cherkasov.util.Browser;
import selenium_cherkasov.util.PropertyLoader;
import selenium_cherkasov.webdriver.WebDriverFactory;

public class ApplicationManager1 implements ApplicationManager {

  private UserHelper userHelper;
  private ApplicationHelper applicationHelper;
  private NavigationHelper navHelper;
  private AjaxHelper ajaxHelper;
  private JsHelper jsHelper;

  private WebDriver driver;
  private String baseUrl;
  
  public ApplicationManager1() {
    baseUrl = PropertyLoader.loadProperty("site.url");
    String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

    Browser browser = new Browser();
    browser.setName(PropertyLoader.loadProperty("browser.name"));
    browser.setVersion(PropertyLoader.loadProperty("browser.version"));
    browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

    String username = PropertyLoader.loadProperty("user.username");
    String password = PropertyLoader.loadProperty("user.password");
    
    driver = WebDriverFactory.getInstance(gridHubUrl, browser, username, password);
    // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    userHelper = new UserHelper1(this);
    applicationHelper = new ApplicationHelper1(this);
    navHelper = new NavigationHelper1(this);
    ajaxHelper = new AjaxHelper1(this);
    jsHelper = new JsHelper1(this);

    getNavigationHelper().openMainPage();
  }
  
  @Override
  public UserHelper getUserHelper() {
    return userHelper;
  }

  @Override
  public ApplicationHelper getApplicationHelper() {
    return applicationHelper;
  }

  @Override
  public NavigationHelper getNavigationHelper() {
    return navHelper;
  }
  
  @Override
  public AjaxHelper getAjaxHelper() {
    return ajaxHelper;
  }

  @Override
  public JsHelper getJsHelper() {
    return jsHelper;
  }
  
  protected WebDriver getWebDriver() {
    return driver;
  }
  
    protected String getBaseUrl() {
    return baseUrl;
  }

  @Override
  public void stop() {
    if (driver != null) {
      driver.quit();
    }
  }


}