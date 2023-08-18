package PageObjectfiles;

import org.openqa.selenium.WebDriver;

import PageObjectfiles.HomePageObject;
import PageObjectfiles.RegisterPageObject;
import PageObjectfiles.URLLoginPageObject;

public class PageObjectManager {
    
	public HomePageObject homepage;
	public RegisterPageObject registerpage;
	public URLLoginPageObject urlloginpage;
	public StackPageObject stackpage;
	public QueuePageObject queuepage;
	public DataStructurePageObject datastructurepage;
	public WebDriver driver;
	public  PageObjectManager( WebDriver driver) {
		this.driver = driver;
	}
	public HomePageObject HomePageObject() {
		 homepage = new HomePageObject(driver);
		 return homepage;
	}
	
	public RegisterPageObject RegisterPageObject() {
		registerpage = new RegisterPageObject(driver);
		 return registerpage;
	}
	public URLLoginPageObject URLLoginPageObject() {
		urlloginpage = new URLLoginPageObject(driver);
		 return urlloginpage;
	}
	public StackPageObject StackPageObject() {
		stackpage = new StackPageObject(driver);
		 return stackpage;
	}
	public QueuePageObject QueuePageObject() {
		queuepage = new QueuePageObject(driver);
		 return queuepage;
	}
	public DataStructurePageObject DataStructurePageObject() {
		datastructurepage = new DataStructurePageObject(driver);
		 return datastructurepage;
	}

}
