Feature: Testme Registration
@registration
  Scenario: registration
    Given the user is in the registration page of the browser application

    When username "techon" ,firstname "tech" ,lastname "stud" ,password "password123" ,confirm password "password123" ,email "techon@gmail.com" ,mobilenumber "1234567890" ,DOB "08/04/2000" ,Address "12 San diago, united states" ,SecurityQuestion "Red" 
    Then user must be redirected to the login page
    
    @login_outline
Scenario Outline: login 
Given User must be in the Login Page
When User must provide registered username credentials "<username>" and "<password>" and click Login
Then Login is done successfully and user is directed to the Home page
Examples:
|username||password|
|Lalitha||Password123|
#Start Case 3
Scenario: search function
Given User providing informaion in search box
When User enters headphones as value in search box
Then the appropriate product is displayed