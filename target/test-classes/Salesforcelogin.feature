Feature: login feature
checking the login feature of firebase app
Background:
    Given User open Salesforce application
 
 Scenario: Login error message to salesforce
    When user on "Loginpage"
    When User enters username into text box
    When user clear textbox password
    When click on login button
    Then verify "Please enter your password." "error" displayed
    
 Scenario: Login to salesforce
    When user on "Loginpage"
    When User enters username into text box
    When User enters paswd into text box
    When click on login button
    When user on "HomePage"
    Then verify "Home" "ForceCom_font" displayed
    
 Scenario: Check remember me
    When user on "Loginpage"
    When User enters username into text box
    When User enters paswd into text box
    When User clicks on "Remember me check box"
    When click on login button
    When user on "HomePage"
    When user menu
    When user logout
    When user on "Loginpage"
    Then verify "mail2raju2001@gmail.com" "idcard-identity" displayed
    
    
 Scenario: Login wrong credentials
   When user on "Loginpage"
   When User enters wrongusername into text box
   When User enters wrongpaswd into text box 
   When click on login button  
   Then verify "Please check your username and password. If you still can't log in, contact your Salesforce administrator." "error" displayed
   
 Scenario: Forgot paasword
   When user on "Loginpage"
   When user clicks on forgot password
   When User enters username into text box
   When click on continue
   Then verify "Check Your Email" "header" displayed
    
    