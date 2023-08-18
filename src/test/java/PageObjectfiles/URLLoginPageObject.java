package PageObjectfiles;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utilities.ExcelUtil;



public class URLLoginPageObject {

	public String Passwordtext;
	public String usernametext;
	public String validtext;
	public WebDriver driver;
	By register = By.xpath("//a[text()='Register!']");
	By username = By.id("id_username");
	By password = By.id("id_password");
	// By Alert = By.xpath("//span[contains(text(),'Please fill out this field')]");
	By Alert = By.xpath("//input[@type='hidden']");
	By roleAlert = By.xpath("//div[@role='alert']");
	By submit = By.xpath("//input[@type='submit']");
	By logindisplay = By.xpath("//ul/a[2]");
	By logout = By.xpath("//a[@href='/logout']");
	By Logoutmessage = By.xpath("//div[@role='alert']");
	By Signin = By.xpath("//a[text()='Sign in']");

	public URLLoginPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public void geturl() {
		driver.get("https://dsportalapp.herokuapp.com/login");
	}

	public void register() {
		driver.findElement(register).click();
	}

	public String currentURL() {
		return driver.getCurrentUrl();
	}

	public void username_password_validation(String Name, String Password,String message) throws InterruptedException {
	
		if (Name.isEmpty())  {
			driver.findElement(username).sendKeys(Name);
			driver.findElement(password).sendKeys(Password);
			driver.findElement(submit).click();
			this.usernametext = driver.findElement(username).getAttribute("validationMessage");
			System.out.println(this.usernametext);
			System.out.println(message);
            Assert.assertEquals(usernametext, message);
			
		
		} else if(Password.isEmpty()){
			driver.findElement(username).sendKeys(Name);
			driver.findElement(password).sendKeys(Password);
			driver.findElement(submit).click();
			this.Passwordtext=driver.findElement(password).getAttribute("validationMessage");
			Assert.assertEquals(Passwordtext, message);
			System.out.println(this.Passwordtext);
			System.out.println(message);
		}
		else {
			driver.findElement(username).sendKeys(Name);
			driver.findElement(password).sendKeys(Password);
			driver.findElement(submit).click();
			this.validtext= driver.findElement(roleAlert).getText();
			Assert.assertEquals(validtext, message);
			System.out.println(this.validtext);
			System.out.println(message);
		}
		}
	

	public String successful_validation(String Name, String Password) {
		driver.findElement(username).sendKeys(Name);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(submit).click();
		return driver.findElement(logindisplay).getText();
	}

	public void signout() {
		driver.findElement(logout).click();
	}

	public String logoutmessage() {
		return driver.findElement(Logoutmessage).getText();
	}

	public Boolean Signindisplay() {
		return driver.findElement(Signin).isDisplayed();
	}
	public void excel_input(String sheet,int row) throws IOException {
		String path= "C:\\Manju\\SDET\\ElearningProject\\src\\test\\resources\\features\\inputdata\\inputs_from_excel.xlsx";
    	List<String> inputs=ExcelUtil.readFromExcel(path, sheet, row);
    	driver.findElement(username).sendKeys(inputs.get(0));
    	driver.findElement(password).sendKeys(inputs.get(1));
    	driver.findElement(submit).click();
	}
	public void error_message()
    {
		 String message = driver.findElement(roleAlert).getText();
		 Assert.assertEquals(message,"Invalid Username and Password" );
		
		}
}
