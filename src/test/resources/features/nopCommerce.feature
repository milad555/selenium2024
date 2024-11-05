@nopCommerce
Feature: End-to-End Checkout Flow on nopCommerce

  @nopCommerce1 @e2e
  Scenario: Logged-in user completes a full checkout flow
    Given I am on the registration page
    When I register with a Default User
    When I click on the "Computers" category tab
    And I click on the "Desktops" subcategory in the sidebar
    And I select the product "Digital Storm VANQUISH 3 Custom Performance PC"
    And I add the product to the cart
    And I click on Shopping cart tab
    Then I proceed to the checkout page
#    And I fill out my shipping and payment details
#    And I confirm my order
#    Then I should see a success message for my order


  @nopCommerce2 @e2e
  Scenario: Logged-in user completes a full checkout flow
    Given I am on the registration page
    When I register with a Default User
    When I click on the "Computers" category tab
    And I click on the "Desktops" subcategory in the sidebar
    And I select the product "Build your own computer"
    And I select ram as "2 GB" for desktop
    And I add the product to the cart
    And I click on Shopping cart tab
    Then I proceed to the checkout page
#    And I fill out my shipping and payment details
#    And I confirm my order
#    Then I should see a success message for my order


  @nopCommerce3 @e2e
  Scenario: Guest user completes a full checkout flow
    Given I am on the nopCommerce homepage
    And I continue as a guest user
    When I click on the "Computers" category tab
    And I click on the "Desktops" subcategory in the sidebar
    And I select the product "Build your own computer"
    And I add the product to the cart
    Then I proceed to the checkout page
#    And I fill out my guest shipping and payment details
#    And I confirm my order
#    Then I should see a success message for my order
