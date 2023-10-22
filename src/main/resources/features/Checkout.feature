Feature: Checkout Web Swag Labs
  #TCC.SHOP.004
  Scenario: Checkout Valid Test
    Given User entering url shop
    When User login
    And User click item add to cart
    And User click cart
    And User click checkout
    And User input firstname
    And User Input lastname
    And User Input zipcode
    And User click continue
    And User click finish
    Then User get text thank you

  #TCC.SHOP.005
  Scenario: Checkout Invalid No Input Data Test
    Given User click back home
    When User click item add to cart
    And User click cart
    And User click checkout
    And User click continue
    Then User get text error firstname required

  #TCC.SHOP.006
  Scenario: Checkout invalid input just firstname Test
    Given User input firstname
    When User click continue
    Then User get text error lastname required