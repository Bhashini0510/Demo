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

Feature: Home Page feature validation

 
  Scenario: Home Page URL
    Given The user lands on DS Algo Portal
    When User enters the home page using Get Started button
    Then User is on Home Page URL
  
    
    Scenario: Content in Home Page
    Given User on Home Page URL
    Then Title of the page NumpyNinja is displayed
    And Data Structures is selected default in dropdown
    And Register with Signin is available
    When User opens the dropdown in homepage
    Then Options Data Structures, Arrays, Linked List, Stack, Queue, Tree and Graph are displayed 
    
  
    Scenario Outline: Drop down selection without login
    When User select an "<option>" in dropdown without login
    Then User gets warning message You are not logged in
    
    Examples:
    |option|
    |Arrays|
    |Linked List|
    |Stack|
    |Queue|
    |Tree|
    |Graph|


    Scenario Outline: Get started button clicked without login
    When User clicks on Get Started button in any "<topic>"
    Then User gets warning message You are not logged in
     Examples:
    |topic|
    |Data Structures-Introduction|
    |Array|
    |Linked List|
    |Stack|
    |Queue|
    |Tree|
    |Graph|
    
    
    Scenario: Register Page Navigation
    # When User clicks Signout
    #Then User navigates to home page
    When User clicks Register
    Then User lands on Register Page
    
     @tag23
    Scenario: Sign in Page Navigation
     #When User clicks Signout
   # Then User navigates to home page
    When User clicks Sign in
    Then User lands on Login Page
    

  