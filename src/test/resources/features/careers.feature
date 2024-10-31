@careers
Feature: Careers Portal

  @careers1
  Scenario: Login to Careers Portal
    Given I navigate to "careers log" page
    Then I verify the page title is "Careers Portal"
    When I fill out username "student@example.com" and password "welcome"
    And I click "Submit" button




    #@careers2
    #Scenario:
    #  Given I navigate to "careers" page
    #  Then I verify the page title is "Careers"
    #  When I fill out the required fields on the form oop
    #  And I submit the form oop
    #  Then I see required fields submitted successfully oop
    #  And I wait for 5000 sec