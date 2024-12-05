Feature: UPS workflows

  Scenario: Validate UPS Form
    Given I navigate to "ups shipment info" page
    When I fill out required fields for shipment information
    #And I wait for 500 sec
    And I submit shipment form
    Then I verify that required fields present on Shipper and Receiver details
