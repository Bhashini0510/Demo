package StepDefinitions;

import org.testng.Assert;

import PageObjectfiles.RegisterPageObject;
import Utilities.Textcontextclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Register_page {
	
	Textcontextclass textcontext;
	RegisterPageObject obj;
	public Register_page(Textcontextclass textcontext) {
		this.textcontext= textcontext;
		this.obj=textcontext.pageobject.RegisterPageObject();
	}	

	@Given("User launches the url {string}")
	public void user_launces_the_url(String url) {
	   obj.launchURL(url);
	}

	@Given("click on Get Started button")
	public void click_on_get_started_button() {
	  obj.getstarted();
	}

	@When("User click on Register link")
	public void user_click_on_register_link() {
	  obj.register_link();
	}

	@When("enters user name as {string} and password as {string} and confirm password same as {string}")
	public void enters_user_name_as_and_password_as_and_confirm_password_same_as(String username, String password, String confirm_password) {
	   obj.register(username,password,confirm_password);
	}

	@When("click on register button")
	public void click_on_register_button() {
	    obj.submit();
	}

	@Then("User is successfully registered")
	public void user_is_successfully_registered() {
		Assert.assertEquals(obj.Successful_message(), "New Account Created. You are logged in as plavwu1234");
	}

	@Then("{string} is launched")
	public void is_launched(String name) {
		System.out.println("Name: "+name);
		System.out.println(obj.currentURL());
		Assert.assertEquals(obj.currentURL(), name);
	}

	@Then("{string} is displayed in the page")
	public void is_displayed_in_the_page(String string) {
		Assert.assertEquals(obj.get_String(), string);
	}
	
	@Given("User is in Register page")
	public void User_is_in_Register_page() {
		obj.registerpageUrl();
	 
	}
    @Then ("{string},{string},{string} User is not able to register and alert {string} is displayed")
    public void user_fills_details(String username, String password,String Confirm_password,String message) {
    	obj.username_password_validation(username,password,Confirm_password,message);
    	
    }
  
	
}
