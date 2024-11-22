@nop
Feature: Category and Sidebar Navigation
  As a new user
  I want to navigate through the categories and sidebar items
  So that I can view products or pages related to my selection

  @nop1
  Scenario: Navigate to a Computers category tab
    Given I open url "https://nop-qa.portnov.com/"
    Then I click on the "Computers" category tab
    Then I should see page title contains "Computers"
#    When I click on "Notebooks" subcategory in the sidebar
#    Then I should see page title contains "Notebooks"

  @nop2
  Scenario: Navigate to a Electronics category tab
    Given I open url "https://nop-qa.portnov.com/"
    When I click on the "Electronics" category tab
    Then I should see page title contains "Electronics"
#    When I click on "Cell phones" subcategory in the sidebar
#    Then I should see page title contains "Cell phones"

  @nop3
  Scenario: Navigate to a Apparel category tab
    Given I open url "https://nop-qa.portnov.com/"
    When I click on the "Apparel" category tab
    Then I should see page title contains "Apparel"
#    When I click on "Shoes" subcategory in the sidebar
#    Then I should see page title contains "Shoes"

  @nop4
  Scenario: Navigate to a Digital category tab
    Given I open url "https://nop-qa.portnov.com/"
    When I click on the "Digital downloads" category tab
    Then I should see page title contains "Digital downloads"
    #When I click on "Notebooks" subcategory in the sidebar
    #Then I should see page title contains "Notebooks"

  @nop5
  Scenario: Navigate to a Books category tab
    Given I open url "https://nop-qa.portnov.com/"
    When I click on the "Books" category tab
    Then I should see page title contains "Books"
    #When I click on "Notebooks" subcategory in the sidebar
    #Then I should see page title contains "Notebooks"

  @nop6
  Scenario: Navigate to a Jewelry category tab
    Given I open url "https://nop-qa.portnov.com/"
    When I click on the "Jewelry" category tab
    Then I should see page title contains "Jewelry"
    #When I click on "Notebooks" subcategory in the sidebar
    #Then I should see page title contains "Notebooks"

  @nop7
  Scenario: Navigate to a Gift category tab
    Given I open url "https://nop-qa.portnov.com/"
    When I click on the "Gift Cards" category tab
    Then I should see page title contains "Gift Cards"

  @nop8
  Scenario: Navigate by hovering over a category
    Given I open url "https://nop-qa.portnov.com/"
    When I hover over "Computers" category
    Then I should see subcategory:
        | Desktops    |
        | Notebooks   |
        | Software    |

    @nop9
    Scenario: Webdriver wait
    Given I open url "https://nop-qa.portnov.com/"
    When I click on the "Computers" category tab
    Then I should see page title contains "Computers"
