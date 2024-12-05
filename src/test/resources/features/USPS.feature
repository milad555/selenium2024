@USPS @smoke
Feature: Test USPS site

  @USPS1
  Scenario: Validate ZIP code for Portnov Computer School
    Given I navigate to "usps priority mail" page
    Then I verify the page title is "Priority Mail | USPS"
    When I click "Ship Now " link
    Then I validate "Already have an account?" message present


  @USPS2
  Scenario: Validate ZIP code for Portnov Computer School 2
    Given I navigate to "usps priority mail" page
    When I hover over "Send" link
    And I click "Look Up a ZIP Code" link
    Then I verify the page title is "ZIP Code™ Lookup | USPS"
    When I click "Find by Address" link
    When I fill Portnov Computer School data
    And I click by "Find" text
    Then I verify Zip code is "94085-4513"

  @usps4

  Scenario: Validate Boxes count
    Given I navigate to "usps lookup a zip code by address" page
    When I hover over Search and search for "Boxes"

#    And I wait for 5 sec
#    And I filter results with "Send"
#    Then I verify 8 resuls are displayed
