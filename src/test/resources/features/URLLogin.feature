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

Feature: Login feature validation

 
 
    
  Scenario Outline: Username and Password validation
    Given User is in Login page
    Then User enters "<username>" and "<password>" : "<message>" is displayed
     
    
 Examples:
| username | password  | message                       |
|          | Welcome1  | Please fill out this field.   |
| par123   |           | Please fill out this field.   |
| par123   | Welcome1  | Invalid Username and Password |

 Scenario Outline: Successful login and logout
    Given User is in Sign in page
    When User enters username "<username>" and password "<password>"
    Then User is in Home page 
    And  Username is displayed 
    When User clicks Signout
    Then User navigates to home page
    And  Succesfully logged out message is displayed
    And  Sign in is displayed
    
 Examples:
| username   | password  | 
| Manju123   | Jan@3232  | 

  Scenario: Register link validation from Sign in page
    Given User is in Sign in page
    When User clicks on Register link
    Then User navigates to Register page
 
 @excel   
  Scenario Outline: User enters invalid username from excel 
    Given User is in Sign in page
    When User enters invalid username and password from sheet "<Sheet>" and rownumber <Row>
    Then Error message is displayed as Invalid username and Password
    
 Examples:
| Sheet     | Row        |
| inputs    | 0          |

    
    
  