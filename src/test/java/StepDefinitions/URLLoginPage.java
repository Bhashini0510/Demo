package StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import PageObjectfiles.URLLoginPageObject;
import Utilities.ExcelUtil;
import Utilities.Textcontextclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class URLLoginPage {
	String Text;
	String Login_Name;
	Textcontextclass textcontext;
	URLLoginPageObject obj;
	public URLLoginPage(Textcontextclass textcontext) {
		this.textcontext= textcontext;
		this.obj=textcontext.pageobject.URLLoginPageObject();
	}
	
	@Given("User is in Login page")
	public void user_is_in_sign_in_page() {
	   obj.geturl();
	}

	@When("User clicks on Register link")
	public void user_clicks_on_register_link() {
	   obj.register();
	}

	@Then("User navigates to Register page")
	public void user_navigates_to_register_page() {
	   Assert.assertEquals(obj.currentURL(), "https://dsportalapp.herokuapp.com/register");
	}

    @Given("User is in Sign in page")
    public void user_is_in_login_page() {
    	 obj.geturl();
    }
    @Then ("User enters {string} and {string} : {string} is displayed")
      public void user_enters_username_password(String username, String password,String message) throws InterruptedException {
    	 obj.username_password_validation(username,password,message);
    	
    }
    
    
    @When ("User enters username {string} and password {string}")
    public void user_enter_successfulvalue(String username, String password) {
    	
    	Login_Name = obj.successful_validation(username,password);
    }
    
	@Then("User is in Home page")
	public void user_is_in_home_page() {
		 Assert.assertEquals(obj.currentURL(), "https://dsportalapp.herokuapp.com/home");
	}

	@Then("Username is displayed")
	public void username_is_displayed() {
		Assert.assertEquals(Login_Name, "Manju123");
	}

	@When("User clicks Signout")
	public void user_clicks_signout() {
	   obj.signout();
	}

	@Then("User navigates to home page")
	public void user_navigates_to_home_page() {
		 Assert.assertEquals(obj.currentURL(), "https://dsportalapp.herokuapp.com/home");
	}

	@Then("Succesfully logged out message is displayed")
	public void succesfully_logged_out_message_is_displayed() {
		Assert.assertEquals(obj.logoutmessage(), "Logged out successfully");
	}

	@Then("Sign in is displayed")
	public void sign_in_is_displayed() {
		Assert.assertTrue(obj.Signindisplay());
	}
    @When("User enters invalid username and password from sheet {string} and rownumber {int}")
    public void User_enters_invalid_username_and_password_from_sheet(String sheet, int row) throws IOException {
    	obj.excel_input(sheet,row);
    	
    }
    @Then("Error message is displayed as Invalid username and Password")
    public void Error_message_is_displayed_as_Invlaid_username_and_Password() {
    	obj.error_message();
    }



}
