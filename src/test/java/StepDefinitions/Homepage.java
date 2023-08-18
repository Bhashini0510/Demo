package StepDefinitions;


import org.testng.Assert;

import PageObjectfiles.HomePageObject;
import Utilities.Textcontextclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Homepage {
	
	Textcontextclass textcontext;
	HomePageObject obj;
	public Homepage(Textcontextclass textcontext) {
		this.textcontext= textcontext;
		this.obj=textcontext.pageobject.HomePageObject();
	}
	
	@Given("The user lands on DS Algo Portal")
	public void the_user_lands_on_ds_algo_portal() {
		obj.startpageURL();
		
	}

	@When("User enters the home page using Get Started button")
	public void user_enters_the_home_page_using_get_started_button() {
	    obj.getstarted();
	}

	@Then("User is on Home Page URL")
	public void user_is_on_home_page_url() {
		Assert.assertEquals(obj.home(),"https://dsportalapp.herokuapp.com/home");
	}
	
	@Given ("User on Home Page URL")
	public void given_user_is_on_home_page_url() {
		obj.homeURL();
	}

	@Then("Title of the page NumpyNinja is displayed")
	public void title_of_the_page_numpy_ninja_is_displayed() {
		Assert.assertEquals(obj.getTitle(),"NumpyNinja");
	}

	@Then("Data Structures is selected default in dropdown")
	public void data_structures_is_selected_default_in_dropdown() {
		Assert.assertEquals(obj.getDefaultdropdown(),"Data Structures");
	}

	@Then("Register with Signin is available")
	public void register_with_signin_is_available() {
	  Assert.assertTrue(obj.isvisible_register()) ;
	  Assert.assertTrue(obj.isvisible_signin()) ;
	}

	@When("User opens the dropdown in homepage")
	public void user_opens_the_dropdown_in_homepage() {
	    obj.dropdownclick();
	}

	@Then("Options Data Structures, Arrays, Linked List, Stack, Queue, Tree and Graph are displayed")
	public void options_data_structures_arrays_linked_list_stack_queue_tree_and_graph_are_displayed() {
		Assert.assertTrue(obj.validation());
	}

	@When("User select an {string} in dropdown without login")
	public void user_select_an_option_in_dropdown_without_login(String option) throws InterruptedException {
		obj.dropselection(option);
	}

	@Then("User gets warning message You are not logged in")
	public void user_gets_warning_message_you_are_not_logged_in() throws InterruptedException {
		obj.alert_message();
		
	}

	@When("User clicks on Get Started button in any {string}")
	public void user_clicks_on_get_started_button_in_any_topic(String topic) throws InterruptedException {
		obj.user_clicks_on_get_started_button_in_any(topic);
	     
	}
	@Then("User gets warning You are not logged in")
	public void user_gets_warning_you_are_not_logged_in() throws InterruptedException {
		obj.alert_message();
	}

	@When("User clicks Register")
	public void user_clicks_register() {
	  obj.registerpage();
	}

	@Then("User lands on Register Page")
	public void user_lands_on_register_page() {
		Assert.assertEquals(obj.registerpageURL(),"https://dsportalapp.herokuapp.com/register");
	}

	@When("User clicks Sign in")
	public void user_clicks_sign_in() {
	  obj.signpage();
	}

	@Then("User lands on Login Page")
	public void user_lands_on_login_page() {
		Assert.assertEquals(obj.signpageURL(),"https://dsportalapp.herokuapp.com/login");
	}




}
