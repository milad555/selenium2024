@nopUsers @smoke
Feature: User Registration and Login
  As a new user
  I want to be able to register and log in to the nopCommerce website
  So that I can access my account

  @nopUsers1
  Scenario: Register a new user
    Given I am on the registration page
    When I register with a Default User
    Then I should see a registration success message
    And I click Logout
    When I am on the login page
    When I enter Default Credentials
   # Then I verify something
