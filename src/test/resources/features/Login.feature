@Feature_File_To_Check_Login_Functionality
Feature: Login page scenarios

  #Description: The purpose of this feature is to test the Login functionality
  Background: 
    Given User opens browzer And enters the URL
    And On Home Page clicks the LogIn Link

  @ValidLogin
  Scenario Outline: User should be able to login only with valid credentials.
    Given User enters the credentials '<Test_Data>'
    And User clicks on LogIn button

    Examples: 
      | Test_Data |
      | TD_01     |

  @InValidLogin
  Scenario Outline: User should not be able to login with Invalid credentials.
    Given User enters the credentials '<Test_Data>'
    And User clicks on LogIn button

    Examples: 
      | Test_Data |
      | TD_02     |
