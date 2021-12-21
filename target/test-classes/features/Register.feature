@Feature_File_To_Check_Register_Functionality
Feature: Register page scenarios
  #Description: The purpose of this feature is to test the Register functionality

  Background: 
    Given User opens browzer And enters the URL
    And On Home Page clicks the Register Link
    
  @RegisteringUser
  Scenario: User should be able to successfully register a user in the application
    Given User enters the data for the registration of the user '<TestData>'
    And User clicks on Register button
    Then User clicks on Continue button
    Then User clicks on LogOut button
    
    Examples: 
      | TestData  |
      | TD_02 		|    