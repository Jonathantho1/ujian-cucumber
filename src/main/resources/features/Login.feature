Feature: Login Web Swag Labs
  # TCC.SHOP.001
  Scenario: Login Valid Test
    Given User enter url shop
    When User input username
    And User input password
    And User click login
    Then User get text product title

  # TCC.SHOP.002
  Scenario: Login Username Invalid Test
    Given User click burger menu
    When User click logout
    And User input invalid username
    And User input password
    And User click login
    Then User get text error invalid

  #TCC.SHOP.003
  Scenario: Login Without Input Test
    Given User enter url shop
    When User click login
    Then User get text error required

