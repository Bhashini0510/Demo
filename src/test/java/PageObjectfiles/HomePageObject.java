package PageObjectfiles;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePageObject {

	public WebDriver driver;
	String expectedMessage,actualMessage;
	By getstarted = By.xpath("//button[text()='Get Started']");
	By Title = By.className("navbar-brand");
	By defaultdropdwon = By.xpath("//a[@data-toggle='dropdown']");
	By register = By.xpath("//a[text()=' Register ']");
	By Signin = By.xpath("//a[text()='Sign in']");
	By listitems = By.xpath("//a[@class='dropdown-item']");
	By GetStarted= By.xpath("//a[text()='Get Started']");
	By Alertselection = By.xpath("//div[@role='alert']");
	By btnGetStarted = By.xpath("//button[@class='btn']");
	Set<String> expectedDropdownList = Set.of("Arrays", "Linked List", "Stack", "Queue", "Tree", "Graph");
	By dropdownText = By.xpath("//div[contains(@class,'nav-item dropdown')]/a") ;
	By alertMessage = By.xpath("//div[contains(@class,'alert')]");

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void startpageURL() {
		driver.get("https://dsportalapp.herokuapp.com/");
	}

	public void getstarted() {
		driver.findElement(getstarted).click();
	}

	public String home() {
		System.out.println(driver.getCurrentUrl());
		return driver.getCurrentUrl();
		
	}

	public void homeURL() {
		driver.get("https://dsportalapp.herokuapp.com/home");
	}

	public String getTitle() {
		return driver.findElement(Title).getText();
	}

	public String getDefaultdropdown() {
		return driver.findElement(defaultdropdwon).getText();
	}

	public boolean isvisible_register() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver.findElement(register).isDisplayed();
	}

	public boolean isvisible_signin() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver.findElement(Signin).isDisplayed();
	}

	public void dropdownclick() {
		driver.findElement(defaultdropdwon).click();
	}

	public boolean validation() {

		String[] itemsneeded = { "Arrays", "Linked List", "Stack", "Queue", "Tree", "Graph" };
        List<WebElement> products = driver.findElements(listitems);
		List <String> productName =new ArrayList<String>();
		for(WebElement product: products) {
			productName.add(product.getText());		
		}
		int count = 0;
		for (int i = 0; i < productName.size(); i++)
		{
			List itemsNeededList = Arrays.asList(itemsneeded);
			if (itemsNeededList.contains(productName.get(i)))
			{
				count++;
			}
		}
		if (count == 6)
			return true;
		else
			return false;
	}

	public void dropselection(String opt)  {
		driver.get("https://dsportalapp.herokuapp.com/");
		String list="";
		if(driver.findElement(btnGetStarted).isDisplayed()) {
			driver.findElement(btnGetStarted).click();
		}
		
		Iterator<String> s = expectedDropdownList.iterator();
		while(s.hasNext()) {
			
			list = s.next();
			if(opt.equalsIgnoreCase(list)) {
				break;
			}
			
		}
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(dropdownText)).perform();
		driver.findElement(dropdownText).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement linkEle = driver.findElement(By.xpath("//a[contains(text(),'"+list+"')]"));
		act.moveToElement(linkEle).perform();
		linkEle.click();
	}
		

	public void alert_message() throws InterruptedException {
		expectedMessage = "You are not logged in";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		actualMessage = driver.findElement(alertMessage).getText().trim();
		Assert.assertEquals(actualMessage, expectedMessage);
		}
	
    public void user_clicks_on_get_started_button_in_any(String topic) {
		
    	driver.get("https://dsportalapp.herokuapp.com/");
		driver.findElement(btnGetStarted).click();
		driver.findElement(By.xpath("//h5[text()='"+topic+ "']/../a")).click();

	}
	
	public void registerpage() {
		
		driver.get("https://dsportalapp.herokuapp.com/");
		driver.findElement(btnGetStarted).click();
		driver.findElement(register).click();
	}
     public String registerpageURL() {
		
		return driver.getCurrentUrl();
	}
     public void signpage() {
 		
    	 driver.get("https://dsportalapp.herokuapp.com/");
 		driver.findElement(btnGetStarted).click();
 		driver.findElement(Signin).click();
 	}
      public String signpageURL() {
 		
 		return driver.getCurrentUrl();
 	}
}