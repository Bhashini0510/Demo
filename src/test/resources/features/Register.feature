#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@register
Feature: Register User to dsportal app
  

  @success
  Scenario: User is able to register into the dsportalapp
    Given User launches the url "https://dsportalapp.herokuapp.com/"
    
    And click on Get Started button
    #When User clicks Signout
    #Then User navigates to home page
    When User click on Register link
    And enters user name as "plavwu1234" and password as "Sep@1234" and confirm password same as "Sep@1234"
    And click on register button
    Then User is successfully registered
    And "https://dsportalapp.herokuapp.com/home" is launched
    And "plavwu1234" is displayed in the page
    
    @failure
    Scenario Outline: User is not able to register into the dsportalapp
   	Given User is in Register page
    Then "<username>","<password>","<confirm>" User is not able to register and alert "<message>" is displayed
    
    Examples: 
    |username|password  |confirm   |   		        message                                  |
    |        |Feb2@3232 |Feb2@3232 |Please fill out this field.                            |
    |tester2 |          |Feb2@3232 |Please fill out this field.                            |
    |tester2 |Feb2@3232 |          |Please fill out this field.                            |
    |tester  |Password_1|Password_1|Invalid User Name	                                     |
    |tester2 |Password  |Password  |Invalid password                                       |
    |tester2 |Password_1|Password  |password_mismatch:The two password fields didn’t match.|
		|nump1234|Password_1|Welcome1	 |User already registered		                             |
		|tester2 |Pass      |Pass    	 |password should contain 8 characters                   |
		|tester2 |1234      |1234    	 |password cannot be only numbers                        |
		|tester2 |tester2   |tester2   |password cannot be same as user name                   |
		|tester2 |Welcome1  |Welcome1  |password cannot be a common password                   |
