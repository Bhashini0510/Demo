package PageObjectfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPageObject {
	public WebDriver driver;
	public String Usernametext;
	public String Passwordtext;
	public String Validtext;
	public String ConfirmPasswordtext;
	By getstarted = By.xpath("//button[text()='Get Started']");
	By register = By.xpath("//a[text()=' Register ']");
	By username = By.id("id_username");
	By password = By.id("id_password1");
	By confirm_password = By.id("id_password2");
	By submit = By.xpath("//input[@type='submit']");
	By Message = By.xpath("//div[@role='alert']");
	By roleAlert = By.xpath("//div[@role='alert']");

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;

}
	public void launchURL(String url) {
		driver.get(url);
	}
	public void getstarted() {
		driver.findElement(getstarted).click();
	}
	public void register_link() {
		 driver.findElement(register).click();;
	}
	public void register(String Name, String Password, String Confirm_password) {
		driver.findElement(username).sendKeys(Name);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(confirm_password).sendKeys(Confirm_password);
		
	}
	public void submit() {
		driver.findElement(submit).click();;
	}
	public String Successful_message() {
		return driver.findElement(Message).getText();
	}
	public String currentURL() {
		return driver.getCurrentUrl();
	}
	public String get_String() {
		String Text=  driver.findElement(Message).getText().split("as")[1].trim();
		return Text;
	}
	public void registerpageUrl() {
		driver.get("https://dsportalapp.herokuapp.com/register");
	}
	public void username_password_validation(String Username,String Password,String Confirm_password,String message) {
		if (Username== "")  {
			driver.findElement(username).sendKeys(Username);
			driver.findElement(password).sendKeys(Password);
			driver.findElement(confirm_password).sendKeys(Confirm_password);
			driver.findElement(submit).click();
			this.Usernametext = driver.findElement(username).getAttribute("validationMessage");
			System.out.println(this.Usernametext);
			System.out.println(message);
			Assert.assertEquals(this.Usernametext,message);
			
		
		} else if(Password==""){
			driver.findElement(username).sendKeys(Username);
			driver.findElement(password).sendKeys(Password);
			driver.findElement(confirm_password).sendKeys(Confirm_password);
			driver.findElement(submit).click();
			this.Passwordtext=driver.findElement(password).getAttribute("validationMessage");
			System.out.println(this.Passwordtext);
			System.out.println(message);
			Assert.assertEquals(this.Passwordtext,message);
		}
		 else if(Confirm_password==""){
				driver.findElement(username).sendKeys(Username);
				driver.findElement(password).sendKeys(Password);
				driver.findElement(confirm_password).sendKeys(Confirm_password);
				driver.findElement(submit).click();
				this.ConfirmPasswordtext=driver.findElement(confirm_password).getAttribute("validationMessage");
				System.out.println(this.ConfirmPasswordtext);
				System.out.println(message);
				Assert.assertEquals(this.ConfirmPasswordtext,message);
			}
		else {
			driver.findElement(username).sendKeys(Username);
			driver.findElement(password).sendKeys(Password);
			driver.findElement(confirm_password).sendKeys(Confirm_password);
			driver.findElement(submit).click();
			this.Validtext= driver.findElement(roleAlert).getText();
			System.out.println(this.Validtext);
			System.out.println(message);
			Assert.assertEquals(this.Validtext,message);
		}
	}
	
	
}
