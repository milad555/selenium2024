@NopFooter
Feature: Footer of the NOP Commerce

  @NopFooter1
  Scenario: Verify Facebook link opens in a new tab
    Given I am on the nopCommerce homepage
    When I click on the "Facebook" link in the footer
    Then I should be redirected to the "Facebook" page
    Then I verify the page title is "NopCommerce | Facebook"
    When I should return back to nopCommerce page

  @NopFooter2
  Scenario: Verify Twitter link opens in a new tab
    Given I am on the nopCommerce homepage
    When I click on the "Twitter" link in the footer
    Then I should be redirected to the "Twitter" page
    Then I verify the page title is "nopCommerce (@nopCommerce) / X"
    When I should return back to nopCommerce page


  @NopFooter3
  Scenario: Verify YouTube link opens in a new tab
    Given I am on the nopCommerce homepage
    When I click on the "YouTube" link in the footer
    Then I should be redirected to the "YouTube" page
    Then I verify the page title is "nopCommerce - YouTube"
    When I should return back to nopCommerce page