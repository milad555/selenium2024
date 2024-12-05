@quote @smoke
Feature: Quote project

  @quote1
  Scenario: Quote smoke test
    Given I navigate to "quote" page
    Then I verify the page title is "Get a Quote"
    When I fill out the required fields on the form
    And I submit the form
    Then I see required fields submitted successfully

  @quote2
  Scenario: Quote smoke test oop
    Given I navigate to "quote" page
    Then I verify the page title is "Get a Quote"
    When I fill out the required fields on the form oop
    And I submit the form oop
    Then I see required fields submitted successfully oop

