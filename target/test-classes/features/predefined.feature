@predefined @smoke
Feature: Predefined steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    And element with xpath "//*[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//*[@name='q']"
    And I click on element with xpath "(//input[@name='btnK'])[2]"
    And I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

 #@predefined4
 #Scenario: NOP Register
 #  Given I open url "https://nop-qa.portnov.com/"
 #  Then I should see page title contains "Your store. Home page title"
 #  And element with xpath "//a[@class='ico-register']" should be present
 #  When I click on element with xpath "//a[@class='ico-register']"
 #  And I wait for 4 sec
 #  Then I should see page title contains "Register"
 #  And I click on element with xpath "//input[@value='M']"
 #  When I type "Spider" into element with xpath "//input[@name='FirstName'] "
 #  When I type "Man" into element with xpath "//input[@id='LastName'] "
 #  And I select from dropdown "DateOfBirthDay" by value "2"
 #  And I select from dropdown "DateOfBirthMonth" by value "January"
 #  And I select from dropdown "DateOfBirthYear" by value "1991"
 #  And I type random text plus "@test.com" into element with xpath "//input[@id='Email'] "
 #  When I type "StarkCorp" into element with xpath "//input[@id='Company']"
 #  When I type "password123" into element with xpath "//input[@id='Password']"
 #  When I type "password123" into element with xpath "//input[@id='ConfirmPassword']"
 #  And I click on element with xpath "//button[@id='register-button']"
 #  Then element with xpath "//div[@class='result']" should contain text "Your registration completed"

  @predefined4
  Scenario: NOP Register
    Given I open url "https://nop-qa.portnov.com/"
    Then I should see page title contains "Your store. Home page title"
    When I click on element with xpath "//a[@class='ico-login']"
    Then I should see page title contains "Your store. Login"

    When I type "milad@test.com" into element with xpath "//input[@id='Email']"
    When I type "test123" into element with xpath "//input[@id='Password']"
    When I click on element with xpath "//button[contains(@class,'login-button')]"
    Then I verify the element with xpath "//a[@class='ico-logout']" is present
#    And element with xpath "//a[@class='ico-register']" should be present
#    When I click on element with xpath "//a[@class='ico-register']"
#    And I wait for 4 sec
#
#    Then I should see page title contains "Register"
#    And I click on element with xpath "RADIO BUTTON"
#    When I type "" into element with xpath ""
#    When I type "" into element with xpath ""
#    And I click on element with xpath ""
#    And I click on element with xpath ""
#    And I click on element with xpath ""
#    When I type "" into element with xpath ""
#
#    When I type "" into element with xpath ""
#    When I type "" into element with xpath "/"
#
#    And I click on element with xpath "Register Button"
#
#    Then element with xpath "After" should contain text "Text"